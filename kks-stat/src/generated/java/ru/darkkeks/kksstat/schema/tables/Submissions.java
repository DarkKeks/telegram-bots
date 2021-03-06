/*
 * This file is generated by jOOQ.
 */
package ru.darkkeks.kksstat.schema.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.darkkeks.kksstat.schema.Keys;
import ru.darkkeks.kksstat.schema.Public;
import ru.darkkeks.kksstat.schema.tables.records.SubmissionsRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Submissions extends TableImpl<SubmissionsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.submissions</code>
     */
    public static final Submissions SUBMISSIONS = new Submissions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SubmissionsRecord> getRecordType() {
        return SubmissionsRecord.class;
    }

    /**
     * The column <code>public.submissions.id</code>.
     */
    public final TableField<SubmissionsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.submissions.login</code>.
     */
    public final TableField<SubmissionsRecord, String> LOGIN = createField(DSL.name("login"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>public.submissions.contest_id</code>.
     */
    public final TableField<SubmissionsRecord, Integer> CONTEST_ID = createField(DSL.name("contest_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.submissions.submit_time</code>.
     */
    public final TableField<SubmissionsRecord, LocalDateTime> SUBMIT_TIME = createField(DSL.name("submit_time"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>public.submissions.standings</code>.
     */
    public final TableField<SubmissionsRecord, JSONB> STANDINGS = createField(DSL.name("standings"), SQLDataType.JSONB.nullable(false), this, "");

    private Submissions(Name alias, Table<SubmissionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Submissions(Name alias, Table<SubmissionsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.submissions</code> table reference
     */
    public Submissions(String alias) {
        this(DSL.name(alias), SUBMISSIONS);
    }

    /**
     * Create an aliased <code>public.submissions</code> table reference
     */
    public Submissions(Name alias) {
        this(alias, SUBMISSIONS);
    }

    /**
     * Create a <code>public.submissions</code> table reference
     */
    public Submissions() {
        this(DSL.name("submissions"), null);
    }

    public <O extends Record> Submissions(Table<O> child, ForeignKey<O, SubmissionsRecord> key) {
        super(child, key, SUBMISSIONS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<SubmissionsRecord, Integer> getIdentity() {
        return (Identity<SubmissionsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<SubmissionsRecord> getPrimaryKey() {
        return Keys.SUBMISSIONS_PKEY;
    }

    @Override
    public List<UniqueKey<SubmissionsRecord>> getKeys() {
        return Arrays.<UniqueKey<SubmissionsRecord>>asList(Keys.SUBMISSIONS_PKEY);
    }

    @Override
    public Submissions as(String alias) {
        return new Submissions(DSL.name(alias), this);
    }

    @Override
    public Submissions as(Name alias) {
        return new Submissions(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Submissions rename(String name) {
        return new Submissions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Submissions rename(Name name) {
        return new Submissions(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, Integer, LocalDateTime, JSONB> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
