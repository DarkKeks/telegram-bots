package ru.darkkeks.telegram.trackyoursheet.sheets

import org.springframework.stereotype.Component
import ru.darkkeks.telegram.trackyoursheet.Range

@Component
class SheetTracker {

    fun addJob(range: Range, listener: EventListener) {

    }

    fun removeJob(range: Range) {

    }

}

//@Component
//class SheetTracker(
//
//) {
//
//    private val scope = CoroutineScope(SupervisorJob())
//
//    private val sheetApi: SheetApi by kodein.instance()
//
//    private val trackRepository: SheetTrackRepository by kodein.instance()
//
//    private val jobs: MutableMap<Id<Range>, ReceiveChannel<DataEvent>> = mutableMapOf()
//
//    private val dataCompareService = DataCompareService()
//
//    fun addJob(range: Range): ReceiveChannel<DataEvent> {
//        require(!jobs.contains(range._id)) {
//            "Job is already being tracked"
//        }
//
//        val channel = scope.produce {
//            when (range.interval) {
//                is PeriodTrackInterval -> {
//                    while (true) {
//                        scope.launch {
//                            runJob(range).forEach { send(it) }
//                        }
//                        delay(range.interval.asDuration().toMillis())
//                    }
//                }
//                else -> throw IllegalArgumentException("Unsupported time interval ${range.interval}")
//            }
//        }
//
//        jobs[range._id] = channel
//        return channel
//    }
//
//    fun removeJob(range: Range) {
//        jobs.remove(range._id)?.cancel()
//    }
//
//    private suspend fun runJob(job: Range) = buildList<DataEvent> {
//        val data = withTimeout(5000) {
//            sheetApi.getRanges(job.sheet, listOf("${job.sheet.sheetName}!${job.range}"))
//        }
//        val sheet = data.sheets.find {
//            it.properties.sheetId == job.sheet.sheetId
//        } ?: throw IllegalStateException("No sheet with id ${job.sheet.id} in response")
//        val grid = sheet.data[0]
//
//        val oldData = trackRepository.getLastData(job._id)
//        val newData = RangeData(grid, job._id, _id = oldData?._id ?: newId())
//
//        if (oldData == null) {
//            add(InitialDataLoadEvent(data))
//        } else {
//            dataCompareService.compare(sheet, oldData, newData) { add(it) }
//        }
//
//        trackRepository.saveData(newData)
//    }
//}
