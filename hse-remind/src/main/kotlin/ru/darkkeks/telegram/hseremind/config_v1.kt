package ru.darkkeks.telegram.hseremind

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import ru.darkkeks.telegram.core.PropertyPresentPolymorphicDeserializer


data class UserSpec(
        val chats: List<ChatSpec>,
        val version: Int = 1
)

data class ChatSpec(
        val name: String,
        val target: Target,
        val rules: List<RuleSpec>
)

data class RuleSpec(
        val source: Source,
        val filter: Filter?
)

@JsonSubTypes(
        JsonSubTypes.Type(value = MeTarget::class, name = "me"),
        JsonSubTypes.Type(value = ChannelTarget::class, name = "channel"),
        JsonSubTypes.Type(value = GroupTarget::class, name = "group")
)
abstract class Target

data class MeTarget(val me: Any) : Target()
data class ChannelTarget(val channel: Long) : Target()
data class GroupTarget(val group: Long) : Target()

@JsonSubTypes(
        JsonSubTypes.Type(value = GroupSource::class, name = "group"),
        JsonSubTypes.Type(value = StudentSource::class, name = "student")
)
abstract class Source

data class GroupSource(val group: String) : Source()
data class StudentSource(val student: String) : Source()

@JsonSubTypes(
        JsonSubTypes.Type(value = LectureNameFilter::class, name = "lecture_name"),
        JsonSubTypes.Type(value = WeekDaysFilter::class, name = "week_days"),
        JsonSubTypes.Type(value = LecturerNameFilter::class, name = "lecturer_name"),
        JsonSubTypes.Type(value = LectureTypeFilter::class, name = "lecture_type"),
        JsonSubTypes.Type(value = AllOfFilter::class, name = "all_of"),
        JsonSubTypes.Type(value = AnyOfFilter::class, name = "any_of"),
        JsonSubTypes.Type(value = NoneOfFilter::class, name = "none_of")
)
abstract class Filter

data class LectureNameFilter(val lectureName: String) : Filter()
data class WeekDaysFilter(val weekDays: List<Int>) : Filter()
data class LecturerNameFilter(val lecturerName: String) : Filter()
data class LectureTypeFilter(val lectureType: String) : Filter()
data class AllOfFilter(val allOf: List<Filter>) : Filter()
data class AnyOfFilter(val anyOf: List<Filter>) : Filter()
data class NoneOfFilter(val noneOf: List<Filter>) : Filter()


val polymorphicModule: SimpleModule = SimpleModule()
        .addDeserializer(Filter::class.java, PropertyPresentPolymorphicDeserializer(Filter::class.java))
        .addDeserializer(Source::class.java, PropertyPresentPolymorphicDeserializer(Source::class.java))
        .addDeserializer(Target::class.java, PropertyPresentPolymorphicDeserializer(Target::class.java))

val readMapper: ObjectMapper = ObjectMapper(YAMLFactory())
        .registerModule(KotlinModule())
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
        .registerModule(polymorphicModule)

val jsonWriteMapper: ObjectMapper = ObjectMapper()
        .registerModule(KotlinModule())
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
        .registerModule(polymorphicModule)