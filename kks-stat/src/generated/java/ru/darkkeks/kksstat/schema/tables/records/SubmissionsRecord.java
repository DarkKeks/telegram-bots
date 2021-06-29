/*
 * This file is generated by jOOQ.
 */
package ru.darkkeks.kksstat.schema.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.JSONB;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import ru.darkkeks.kksstat.schema.tables.Submissions;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SubmissionsRecord extends UpdatableRecordImpl<SubmissionsRecord> implements Record5<Integer, String, Integer, LocalDateTime, JSONB> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.submissions.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.submissions.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.submissions.login</code>.
     */
    public void setLogin(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.submissions.login</code>.
     */
    public String getLogin() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.submissions.contest_id</code>.
     */
    public void setContestId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.submissions.contest_id</code>.
     */
    public Integer getContestId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.submissions.submit_time</code>.
     */
    public void setSubmitTime(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.submissions.submit_time</code>.
     */
    public LocalDateTime getSubmitTime() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.submissions.standings</code>.
     */
    public void setStandings(JSONB value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.submissions.standings</code>.
     */
    public JSONB getStandings() {
        return (JSONB) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, Integer, LocalDateTime, JSONB> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, Integer, LocalDateTime, JSONB> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Submissions.SUBMISSIONS.ID;
    }

    @Override
    public Field<String> field2() {
        return Submissions.SUBMISSIONS.LOGIN;
    }

    @Override
    public Field<Integer> field3() {
        return Submissions.SUBMISSIONS.CONTEST_ID;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Submissions.SUBMISSIONS.SUBMIT_TIME;
    }

    @Override
    public Field<JSONB> field5() {
        return Submissions.SUBMISSIONS.STANDINGS;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getLogin();
    }

    @Override
    public Integer component3() {
        return getContestId();
    }

    @Override
    public LocalDateTime component4() {
        return getSubmitTime();
    }

    @Override
    public JSONB component5() {
        return getStandings();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getLogin();
    }

    @Override
    public Integer value3() {
        return getContestId();
    }

    @Override
    public LocalDateTime value4() {
        return getSubmitTime();
    }

    @Override
    public JSONB value5() {
        return getStandings();
    }

    @Override
    public SubmissionsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public SubmissionsRecord value2(String value) {
        setLogin(value);
        return this;
    }

    @Override
    public SubmissionsRecord value3(Integer value) {
        setContestId(value);
        return this;
    }

    @Override
    public SubmissionsRecord value4(LocalDateTime value) {
        setSubmitTime(value);
        return this;
    }

    @Override
    public SubmissionsRecord value5(JSONB value) {
        setStandings(value);
        return this;
    }

    @Override
    public SubmissionsRecord values(Integer value1, String value2, Integer value3, LocalDateTime value4, JSONB value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SubmissionsRecord
     */
    public SubmissionsRecord() {
        super(Submissions.SUBMISSIONS);
    }

    /**
     * Create a detached, initialised SubmissionsRecord
     */
    public SubmissionsRecord(Integer id, String login, Integer contestId, LocalDateTime submitTime, JSONB standings) {
        super(Submissions.SUBMISSIONS);

        setId(id);
        setLogin(login);
        setContestId(contestId);
        setSubmitTime(submitTime);
        setStandings(standings);
    }
}
