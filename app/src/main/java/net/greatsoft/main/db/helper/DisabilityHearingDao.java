package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.disability.DisabilityHearing;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DISABILITY_HEARING".
*/
public class DisabilityHearingDao extends AbstractDao<DisabilityHearing, Void> {

    public static final String TABLENAME = "DISABILITY_HEARING";

    /**
     * Properties of entity DisabilityHearing.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property DisabilityHearingId = new Property(0, String.class, "disabilityHearingId", false, "DISABILITY_HEARING_ID");
        public final static Property PersonInfoId = new Property(1, String.class, "personInfoId", false, "PERSON_INFO_ID");
        public final static Property ManageOrgId = new Property(2, String.class, "manageOrgId", false, "MANAGE_ORG_ID");
        public final static Property DisabilityHearingNo = new Property(3, String.class, "disabilityHearingNo", false, "DISABILITY_HEARING_NO");
        public final static Property DisabilityHearingDate = new Property(4, java.util.Date.class, "disabilityHearingDate", false, "DISABILITY_HEARING_DATE");
        public final static Property DisabilityReasonCode = new Property(5, String.class, "disabilityReasonCode", false, "DISABILITY_REASON_CODE");
        public final static Property DisabilityReasonValue = new Property(6, String.class, "disabilityReasonValue", false, "DISABILITY_REASON_VALUE");
        public final static Property DisabilityGrade = new Property(7, String.class, "disabilityGrade", false, "DISABILITY_GRADE");
        public final static Property DurationTimeCode = new Property(8, String.class, "durationTimeCode", false, "DURATION_TIME_CODE");
        public final static Property SelfCareAssessCode = new Property(9, String.class, "selfCareAssessCode", false, "SELF_CARE_ASSESS_CODE");
        public final static Property GuardianName = new Property(10, String.class, "guardianName", false, "GUARDIAN_NAME");
        public final static Property GuardianTelNo = new Property(11, String.class, "guardianTelNo", false, "GUARDIAN_TEL_NO");
        public final static Property EducationBlindCode = new Property(12, String.class, "educationBlindCode", false, "EDUCATION_BLIND_CODE");
        public final static Property EducationBlindValue = new Property(13, String.class, "educationBlindValue", false, "EDUCATION_BLIND_VALUE");
        public final static Property EducationDeafCode = new Property(14, String.class, "educationDeafCode", false, "EDUCATION_DEAF_CODE");
        public final static Property EducationDeafValue = new Property(15, String.class, "educationDeafValue", false, "EDUCATION_DEAF_VALUE");
        public final static Property EducationOtherCode = new Property(16, String.class, "educationOtherCode", false, "EDUCATION_OTHER_CODE");
        public final static Property EducationOtherValue = new Property(17, String.class, "educationOtherValue", false, "EDUCATION_OTHER_VALUE");
        public final static Property EmploymentCode = new Property(18, String.class, "employmentCode", false, "EMPLOYMENT_CODE");
        public final static Property EmploymentValue = new Property(19, String.class, "employmentValue", false, "EMPLOYMENT_VALUE");
        public final static Property WorkUnit = new Property(20, String.class, "workUnit", false, "WORK_UNIT");
        public final static Property WorkUnitTel = new Property(21, String.class, "workUnitTel", false, "WORK_UNIT_TEL");
        public final static Property AverageIncome = new Property(22, String.class, "averageIncome", false, "AVERAGE_INCOME");
        public final static Property LaborAbility = new Property(23, String.class, "laborAbility", false, "LABOR_ABILITY");
        public final static Property LaborSkill = new Property(24, String.class, "laborSkill", false, "LABOR_SKILL");
        public final static Property HearEnvironmentCode = new Property(25, String.class, "hearEnvironmentCode", false, "HEAR_ENVIRONMENT_CODE");
        public final static Property HearSpeechCode = new Property(26, String.class, "hearSpeechCode", false, "HEAR_SPEECH_CODE");
        public final static Property LanguageAbility = new Property(27, String.class, "languageAbility", false, "LANGUAGE_ABILITY");
        public final static Property LipreadingAbility = new Property(28, String.class, "lipreadingAbility", false, "LIPREADING_ABILITY");
        public final static Property Rehabilitation = new Property(29, String.class, "rehabilitation", false, "REHABILITATION");
        public final static Property RehabilitationNeeds = new Property(30, String.class, "rehabilitationNeeds", false, "REHABILITATION_NEEDS");
        public final static Property NextFollowupDate = new Property(31, java.util.Date.class, "nextFollowupDate", false, "NEXT_FOLLOWUP_DATE");
        public final static Property FollowupDate = new Property(32, java.util.Date.class, "followupDate", false, "FOLLOWUP_DATE");
        public final static Property FollowupDoctorId = new Property(33, String.class, "followupDoctorId", false, "FOLLOWUP_DOCTOR_ID");
        public final static Property FollowupDoctorName = new Property(34, String.class, "followupDoctorName", false, "FOLLOWUP_DOCTOR_NAME");
        public final static Property IsCancel = new Property(35, Integer.class, "isCancel", false, "IS_CANCEL");
        public final static Property CreateOrgId = new Property(36, String.class, "createOrgId", false, "CREATE_ORG_ID");
        public final static Property OrgName = new Property(37, String.class, "orgName", false, "ORG_NAME");
        public final static Property CreatorId = new Property(38, String.class, "creatorId", false, "CREATOR_ID");
        public final static Property Creator = new Property(39, String.class, "creator", false, "CREATOR");
        public final static Property CreateTime = new Property(40, java.util.Date.class, "createTime", false, "CREATE_TIME");
        public final static Property ModifiedOrgId = new Property(41, String.class, "modifiedOrgId", false, "MODIFIED_ORG_ID");
        public final static Property ModifiedOrgName = new Property(42, String.class, "modifiedOrgName", false, "MODIFIED_ORG_NAME");
        public final static Property ModifierId = new Property(43, String.class, "modifierId", false, "MODIFIER_ID");
        public final static Property Modifier = new Property(44, String.class, "modifier", false, "MODIFIER");
        public final static Property ModifiedTime = new Property(45, java.util.Date.class, "modifiedTime", false, "MODIFIED_TIME");
        public final static Property AssessmentCount = new Property(46, Integer.class, "assessmentCount", false, "ASSESSMENT_COUNT");
        public final static Property MissingCount = new Property(47, Integer.class, "missingCount", false, "MISSING_COUNT");
        public final static Property IntactRate = new Property(48, Double.class, "intactRate", false, "INTACT_RATE");
    };


    public DisabilityHearingDao(DaoConfig config) {
        super(config);
    }
    
    public DisabilityHearingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DISABILITY_HEARING\" (" + //
                "\"DISABILITY_HEARING_ID\" TEXT," + // 0: disabilityHearingId
                "\"PERSON_INFO_ID\" TEXT," + // 1: personInfoId
                "\"MANAGE_ORG_ID\" TEXT," + // 2: manageOrgId
                "\"DISABILITY_HEARING_NO\" TEXT," + // 3: disabilityHearingNo
                "\"DISABILITY_HEARING_DATE\" INTEGER," + // 4: disabilityHearingDate
                "\"DISABILITY_REASON_CODE\" TEXT," + // 5: disabilityReasonCode
                "\"DISABILITY_REASON_VALUE\" TEXT," + // 6: disabilityReasonValue
                "\"DISABILITY_GRADE\" TEXT," + // 7: disabilityGrade
                "\"DURATION_TIME_CODE\" TEXT," + // 8: durationTimeCode
                "\"SELF_CARE_ASSESS_CODE\" TEXT," + // 9: selfCareAssessCode
                "\"GUARDIAN_NAME\" TEXT," + // 10: guardianName
                "\"GUARDIAN_TEL_NO\" TEXT," + // 11: guardianTelNo
                "\"EDUCATION_BLIND_CODE\" TEXT," + // 12: educationBlindCode
                "\"EDUCATION_BLIND_VALUE\" TEXT," + // 13: educationBlindValue
                "\"EDUCATION_DEAF_CODE\" TEXT," + // 14: educationDeafCode
                "\"EDUCATION_DEAF_VALUE\" TEXT," + // 15: educationDeafValue
                "\"EDUCATION_OTHER_CODE\" TEXT," + // 16: educationOtherCode
                "\"EDUCATION_OTHER_VALUE\" TEXT," + // 17: educationOtherValue
                "\"EMPLOYMENT_CODE\" TEXT," + // 18: employmentCode
                "\"EMPLOYMENT_VALUE\" TEXT," + // 19: employmentValue
                "\"WORK_UNIT\" TEXT," + // 20: workUnit
                "\"WORK_UNIT_TEL\" TEXT," + // 21: workUnitTel
                "\"AVERAGE_INCOME\" TEXT," + // 22: averageIncome
                "\"LABOR_ABILITY\" TEXT," + // 23: laborAbility
                "\"LABOR_SKILL\" TEXT," + // 24: laborSkill
                "\"HEAR_ENVIRONMENT_CODE\" TEXT," + // 25: hearEnvironmentCode
                "\"HEAR_SPEECH_CODE\" TEXT," + // 26: hearSpeechCode
                "\"LANGUAGE_ABILITY\" TEXT," + // 27: languageAbility
                "\"LIPREADING_ABILITY\" TEXT," + // 28: lipreadingAbility
                "\"REHABILITATION\" TEXT," + // 29: rehabilitation
                "\"REHABILITATION_NEEDS\" TEXT," + // 30: rehabilitationNeeds
                "\"NEXT_FOLLOWUP_DATE\" INTEGER," + // 31: nextFollowupDate
                "\"FOLLOWUP_DATE\" INTEGER," + // 32: followupDate
                "\"FOLLOWUP_DOCTOR_ID\" TEXT," + // 33: followupDoctorId
                "\"FOLLOWUP_DOCTOR_NAME\" TEXT," + // 34: followupDoctorName
                "\"IS_CANCEL\" INTEGER," + // 35: isCancel
                "\"CREATE_ORG_ID\" TEXT," + // 36: createOrgId
                "\"ORG_NAME\" TEXT," + // 37: orgName
                "\"CREATOR_ID\" TEXT," + // 38: creatorId
                "\"CREATOR\" TEXT," + // 39: creator
                "\"CREATE_TIME\" INTEGER," + // 40: createTime
                "\"MODIFIED_ORG_ID\" TEXT," + // 41: modifiedOrgId
                "\"MODIFIED_ORG_NAME\" TEXT," + // 42: modifiedOrgName
                "\"MODIFIER_ID\" TEXT," + // 43: modifierId
                "\"MODIFIER\" TEXT," + // 44: modifier
                "\"MODIFIED_TIME\" INTEGER," + // 45: modifiedTime
                "\"ASSESSMENT_COUNT\" INTEGER," + // 46: assessmentCount
                "\"MISSING_COUNT\" INTEGER," + // 47: missingCount
                "\"INTACT_RATE\" REAL);"); // 48: intactRate
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DISABILITY_HEARING\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DisabilityHearing entity) {
        stmt.clearBindings();
 
        String disabilityHearingId = entity.getDisabilityHearingId();
        if (disabilityHearingId != null) {
            stmt.bindString(1, disabilityHearingId);
        }
 
        String personInfoId = entity.getPersonInfoId();
        if (personInfoId != null) {
            stmt.bindString(2, personInfoId);
        }
 
        String manageOrgId = entity.getManageOrgId();
        if (manageOrgId != null) {
            stmt.bindString(3, manageOrgId);
        }
 
        String disabilityHearingNo = entity.getDisabilityHearingNo();
        if (disabilityHearingNo != null) {
            stmt.bindString(4, disabilityHearingNo);
        }
 
        java.util.Date disabilityHearingDate = entity.getDisabilityHearingDate();
        if (disabilityHearingDate != null) {
            stmt.bindLong(5, disabilityHearingDate.getTime());
        }
 
        String disabilityReasonCode = entity.getDisabilityReasonCode();
        if (disabilityReasonCode != null) {
            stmt.bindString(6, disabilityReasonCode);
        }
 
        String disabilityReasonValue = entity.getDisabilityReasonValue();
        if (disabilityReasonValue != null) {
            stmt.bindString(7, disabilityReasonValue);
        }
 
        String disabilityGrade = entity.getDisabilityGrade();
        if (disabilityGrade != null) {
            stmt.bindString(8, disabilityGrade);
        }
 
        String durationTimeCode = entity.getDurationTimeCode();
        if (durationTimeCode != null) {
            stmt.bindString(9, durationTimeCode);
        }
 
        String selfCareAssessCode = entity.getSelfCareAssessCode();
        if (selfCareAssessCode != null) {
            stmt.bindString(10, selfCareAssessCode);
        }
 
        String guardianName = entity.getGuardianName();
        if (guardianName != null) {
            stmt.bindString(11, guardianName);
        }
 
        String guardianTelNo = entity.getGuardianTelNo();
        if (guardianTelNo != null) {
            stmt.bindString(12, guardianTelNo);
        }
 
        String educationBlindCode = entity.getEducationBlindCode();
        if (educationBlindCode != null) {
            stmt.bindString(13, educationBlindCode);
        }
 
        String educationBlindValue = entity.getEducationBlindValue();
        if (educationBlindValue != null) {
            stmt.bindString(14, educationBlindValue);
        }
 
        String educationDeafCode = entity.getEducationDeafCode();
        if (educationDeafCode != null) {
            stmt.bindString(15, educationDeafCode);
        }
 
        String educationDeafValue = entity.getEducationDeafValue();
        if (educationDeafValue != null) {
            stmt.bindString(16, educationDeafValue);
        }
 
        String educationOtherCode = entity.getEducationOtherCode();
        if (educationOtherCode != null) {
            stmt.bindString(17, educationOtherCode);
        }
 
        String educationOtherValue = entity.getEducationOtherValue();
        if (educationOtherValue != null) {
            stmt.bindString(18, educationOtherValue);
        }
 
        String employmentCode = entity.getEmploymentCode();
        if (employmentCode != null) {
            stmt.bindString(19, employmentCode);
        }
 
        String employmentValue = entity.getEmploymentValue();
        if (employmentValue != null) {
            stmt.bindString(20, employmentValue);
        }
 
        String workUnit = entity.getWorkUnit();
        if (workUnit != null) {
            stmt.bindString(21, workUnit);
        }
 
        String workUnitTel = entity.getWorkUnitTel();
        if (workUnitTel != null) {
            stmt.bindString(22, workUnitTel);
        }
 
        String averageIncome = entity.getAverageIncome();
        if (averageIncome != null) {
            stmt.bindString(23, averageIncome);
        }
 
        String laborAbility = entity.getLaborAbility();
        if (laborAbility != null) {
            stmt.bindString(24, laborAbility);
        }
 
        String laborSkill = entity.getLaborSkill();
        if (laborSkill != null) {
            stmt.bindString(25, laborSkill);
        }
 
        String hearEnvironmentCode = entity.getHearEnvironmentCode();
        if (hearEnvironmentCode != null) {
            stmt.bindString(26, hearEnvironmentCode);
        }
 
        String hearSpeechCode = entity.getHearSpeechCode();
        if (hearSpeechCode != null) {
            stmt.bindString(27, hearSpeechCode);
        }
 
        String languageAbility = entity.getLanguageAbility();
        if (languageAbility != null) {
            stmt.bindString(28, languageAbility);
        }
 
        String lipreadingAbility = entity.getLipreadingAbility();
        if (lipreadingAbility != null) {
            stmt.bindString(29, lipreadingAbility);
        }
 
        String rehabilitation = entity.getRehabilitation();
        if (rehabilitation != null) {
            stmt.bindString(30, rehabilitation);
        }
 
        String rehabilitationNeeds = entity.getRehabilitationNeeds();
        if (rehabilitationNeeds != null) {
            stmt.bindString(31, rehabilitationNeeds);
        }
 
        java.util.Date nextFollowupDate = entity.getNextFollowupDate();
        if (nextFollowupDate != null) {
            stmt.bindLong(32, nextFollowupDate.getTime());
        }
 
        java.util.Date followupDate = entity.getFollowupDate();
        if (followupDate != null) {
            stmt.bindLong(33, followupDate.getTime());
        }
 
        String followupDoctorId = entity.getFollowupDoctorId();
        if (followupDoctorId != null) {
            stmt.bindString(34, followupDoctorId);
        }
 
        String followupDoctorName = entity.getFollowupDoctorName();
        if (followupDoctorName != null) {
            stmt.bindString(35, followupDoctorName);
        }
 
        Integer isCancel = entity.getIsCancel();
        if (isCancel != null) {
            stmt.bindLong(36, isCancel);
        }
 
        String createOrgId = entity.getCreateOrgId();
        if (createOrgId != null) {
            stmt.bindString(37, createOrgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(38, orgName);
        }
 
        String creatorId = entity.getCreatorId();
        if (creatorId != null) {
            stmt.bindString(39, creatorId);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(40, creator);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(41, createTime.getTime());
        }
 
        String modifiedOrgId = entity.getModifiedOrgId();
        if (modifiedOrgId != null) {
            stmt.bindString(42, modifiedOrgId);
        }
 
        String modifiedOrgName = entity.getModifiedOrgName();
        if (modifiedOrgName != null) {
            stmt.bindString(43, modifiedOrgName);
        }
 
        String modifierId = entity.getModifierId();
        if (modifierId != null) {
            stmt.bindString(44, modifierId);
        }
 
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(45, modifier);
        }
 
        java.util.Date modifiedTime = entity.getModifiedTime();
        if (modifiedTime != null) {
            stmt.bindLong(46, modifiedTime.getTime());
        }
 
        Integer assessmentCount = entity.getAssessmentCount();
        if (assessmentCount != null) {
            stmt.bindLong(47, assessmentCount);
        }
 
        Integer missingCount = entity.getMissingCount();
        if (missingCount != null) {
            stmt.bindLong(48, missingCount);
        }
 
        Double intactRate = entity.getIntactRate();
        if (intactRate != null) {
            stmt.bindDouble(49, intactRate);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DisabilityHearing entity) {
        stmt.clearBindings();
 
        String disabilityHearingId = entity.getDisabilityHearingId();
        if (disabilityHearingId != null) {
            stmt.bindString(1, disabilityHearingId);
        }
 
        String personInfoId = entity.getPersonInfoId();
        if (personInfoId != null) {
            stmt.bindString(2, personInfoId);
        }
 
        String manageOrgId = entity.getManageOrgId();
        if (manageOrgId != null) {
            stmt.bindString(3, manageOrgId);
        }
 
        String disabilityHearingNo = entity.getDisabilityHearingNo();
        if (disabilityHearingNo != null) {
            stmt.bindString(4, disabilityHearingNo);
        }
 
        java.util.Date disabilityHearingDate = entity.getDisabilityHearingDate();
        if (disabilityHearingDate != null) {
            stmt.bindLong(5, disabilityHearingDate.getTime());
        }
 
        String disabilityReasonCode = entity.getDisabilityReasonCode();
        if (disabilityReasonCode != null) {
            stmt.bindString(6, disabilityReasonCode);
        }
 
        String disabilityReasonValue = entity.getDisabilityReasonValue();
        if (disabilityReasonValue != null) {
            stmt.bindString(7, disabilityReasonValue);
        }
 
        String disabilityGrade = entity.getDisabilityGrade();
        if (disabilityGrade != null) {
            stmt.bindString(8, disabilityGrade);
        }
 
        String durationTimeCode = entity.getDurationTimeCode();
        if (durationTimeCode != null) {
            stmt.bindString(9, durationTimeCode);
        }
 
        String selfCareAssessCode = entity.getSelfCareAssessCode();
        if (selfCareAssessCode != null) {
            stmt.bindString(10, selfCareAssessCode);
        }
 
        String guardianName = entity.getGuardianName();
        if (guardianName != null) {
            stmt.bindString(11, guardianName);
        }
 
        String guardianTelNo = entity.getGuardianTelNo();
        if (guardianTelNo != null) {
            stmt.bindString(12, guardianTelNo);
        }
 
        String educationBlindCode = entity.getEducationBlindCode();
        if (educationBlindCode != null) {
            stmt.bindString(13, educationBlindCode);
        }
 
        String educationBlindValue = entity.getEducationBlindValue();
        if (educationBlindValue != null) {
            stmt.bindString(14, educationBlindValue);
        }
 
        String educationDeafCode = entity.getEducationDeafCode();
        if (educationDeafCode != null) {
            stmt.bindString(15, educationDeafCode);
        }
 
        String educationDeafValue = entity.getEducationDeafValue();
        if (educationDeafValue != null) {
            stmt.bindString(16, educationDeafValue);
        }
 
        String educationOtherCode = entity.getEducationOtherCode();
        if (educationOtherCode != null) {
            stmt.bindString(17, educationOtherCode);
        }
 
        String educationOtherValue = entity.getEducationOtherValue();
        if (educationOtherValue != null) {
            stmt.bindString(18, educationOtherValue);
        }
 
        String employmentCode = entity.getEmploymentCode();
        if (employmentCode != null) {
            stmt.bindString(19, employmentCode);
        }
 
        String employmentValue = entity.getEmploymentValue();
        if (employmentValue != null) {
            stmt.bindString(20, employmentValue);
        }
 
        String workUnit = entity.getWorkUnit();
        if (workUnit != null) {
            stmt.bindString(21, workUnit);
        }
 
        String workUnitTel = entity.getWorkUnitTel();
        if (workUnitTel != null) {
            stmt.bindString(22, workUnitTel);
        }
 
        String averageIncome = entity.getAverageIncome();
        if (averageIncome != null) {
            stmt.bindString(23, averageIncome);
        }
 
        String laborAbility = entity.getLaborAbility();
        if (laborAbility != null) {
            stmt.bindString(24, laborAbility);
        }
 
        String laborSkill = entity.getLaborSkill();
        if (laborSkill != null) {
            stmt.bindString(25, laborSkill);
        }
 
        String hearEnvironmentCode = entity.getHearEnvironmentCode();
        if (hearEnvironmentCode != null) {
            stmt.bindString(26, hearEnvironmentCode);
        }
 
        String hearSpeechCode = entity.getHearSpeechCode();
        if (hearSpeechCode != null) {
            stmt.bindString(27, hearSpeechCode);
        }
 
        String languageAbility = entity.getLanguageAbility();
        if (languageAbility != null) {
            stmt.bindString(28, languageAbility);
        }
 
        String lipreadingAbility = entity.getLipreadingAbility();
        if (lipreadingAbility != null) {
            stmt.bindString(29, lipreadingAbility);
        }
 
        String rehabilitation = entity.getRehabilitation();
        if (rehabilitation != null) {
            stmt.bindString(30, rehabilitation);
        }
 
        String rehabilitationNeeds = entity.getRehabilitationNeeds();
        if (rehabilitationNeeds != null) {
            stmt.bindString(31, rehabilitationNeeds);
        }
 
        java.util.Date nextFollowupDate = entity.getNextFollowupDate();
        if (nextFollowupDate != null) {
            stmt.bindLong(32, nextFollowupDate.getTime());
        }
 
        java.util.Date followupDate = entity.getFollowupDate();
        if (followupDate != null) {
            stmt.bindLong(33, followupDate.getTime());
        }
 
        String followupDoctorId = entity.getFollowupDoctorId();
        if (followupDoctorId != null) {
            stmt.bindString(34, followupDoctorId);
        }
 
        String followupDoctorName = entity.getFollowupDoctorName();
        if (followupDoctorName != null) {
            stmt.bindString(35, followupDoctorName);
        }
 
        Integer isCancel = entity.getIsCancel();
        if (isCancel != null) {
            stmt.bindLong(36, isCancel);
        }
 
        String createOrgId = entity.getCreateOrgId();
        if (createOrgId != null) {
            stmt.bindString(37, createOrgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(38, orgName);
        }
 
        String creatorId = entity.getCreatorId();
        if (creatorId != null) {
            stmt.bindString(39, creatorId);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(40, creator);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(41, createTime.getTime());
        }
 
        String modifiedOrgId = entity.getModifiedOrgId();
        if (modifiedOrgId != null) {
            stmt.bindString(42, modifiedOrgId);
        }
 
        String modifiedOrgName = entity.getModifiedOrgName();
        if (modifiedOrgName != null) {
            stmt.bindString(43, modifiedOrgName);
        }
 
        String modifierId = entity.getModifierId();
        if (modifierId != null) {
            stmt.bindString(44, modifierId);
        }
 
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(45, modifier);
        }
 
        java.util.Date modifiedTime = entity.getModifiedTime();
        if (modifiedTime != null) {
            stmt.bindLong(46, modifiedTime.getTime());
        }
 
        Integer assessmentCount = entity.getAssessmentCount();
        if (assessmentCount != null) {
            stmt.bindLong(47, assessmentCount);
        }
 
        Integer missingCount = entity.getMissingCount();
        if (missingCount != null) {
            stmt.bindLong(48, missingCount);
        }
 
        Double intactRate = entity.getIntactRate();
        if (intactRate != null) {
            stmt.bindDouble(49, intactRate);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public DisabilityHearing readEntity(Cursor cursor, int offset) {
        DisabilityHearing entity = new DisabilityHearing( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // disabilityHearingId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // personInfoId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // manageOrgId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // disabilityHearingNo
            cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)), // disabilityHearingDate
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // disabilityReasonCode
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // disabilityReasonValue
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // disabilityGrade
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // durationTimeCode
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // selfCareAssessCode
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // guardianName
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // guardianTelNo
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // educationBlindCode
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // educationBlindValue
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // educationDeafCode
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // educationDeafValue
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // educationOtherCode
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // educationOtherValue
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // employmentCode
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // employmentValue
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // workUnit
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // workUnitTel
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // averageIncome
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // laborAbility
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // laborSkill
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // hearEnvironmentCode
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // hearSpeechCode
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // languageAbility
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // lipreadingAbility
            cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), // rehabilitation
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), // rehabilitationNeeds
            cursor.isNull(offset + 31) ? null : new java.util.Date(cursor.getLong(offset + 31)), // nextFollowupDate
            cursor.isNull(offset + 32) ? null : new java.util.Date(cursor.getLong(offset + 32)), // followupDate
            cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33), // followupDoctorId
            cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34), // followupDoctorName
            cursor.isNull(offset + 35) ? null : cursor.getInt(offset + 35), // isCancel
            cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36), // createOrgId
            cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37), // orgName
            cursor.isNull(offset + 38) ? null : cursor.getString(offset + 38), // creatorId
            cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39), // creator
            cursor.isNull(offset + 40) ? null : new java.util.Date(cursor.getLong(offset + 40)), // createTime
            cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41), // modifiedOrgId
            cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42), // modifiedOrgName
            cursor.isNull(offset + 43) ? null : cursor.getString(offset + 43), // modifierId
            cursor.isNull(offset + 44) ? null : cursor.getString(offset + 44), // modifier
            cursor.isNull(offset + 45) ? null : new java.util.Date(cursor.getLong(offset + 45)), // modifiedTime
            cursor.isNull(offset + 46) ? null : cursor.getInt(offset + 46), // assessmentCount
            cursor.isNull(offset + 47) ? null : cursor.getInt(offset + 47), // missingCount
            cursor.isNull(offset + 48) ? null : cursor.getDouble(offset + 48) // intactRate
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DisabilityHearing entity, int offset) {
        entity.setDisabilityHearingId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPersonInfoId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setManageOrgId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDisabilityHearingNo(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDisabilityHearingDate(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
        entity.setDisabilityReasonCode(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDisabilityReasonValue(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDisabilityGrade(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDurationTimeCode(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setSelfCareAssessCode(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setGuardianName(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setGuardianTelNo(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setEducationBlindCode(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setEducationBlindValue(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setEducationDeafCode(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setEducationDeafValue(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setEducationOtherCode(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setEducationOtherValue(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setEmploymentCode(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setEmploymentValue(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setWorkUnit(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setWorkUnitTel(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setAverageIncome(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setLaborAbility(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setLaborSkill(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setHearEnvironmentCode(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setHearSpeechCode(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setLanguageAbility(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setLipreadingAbility(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setRehabilitation(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setRehabilitationNeeds(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setNextFollowupDate(cursor.isNull(offset + 31) ? null : new java.util.Date(cursor.getLong(offset + 31)));
        entity.setFollowupDate(cursor.isNull(offset + 32) ? null : new java.util.Date(cursor.getLong(offset + 32)));
        entity.setFollowupDoctorId(cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33));
        entity.setFollowupDoctorName(cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34));
        entity.setIsCancel(cursor.isNull(offset + 35) ? null : cursor.getInt(offset + 35));
        entity.setCreateOrgId(cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36));
        entity.setOrgName(cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37));
        entity.setCreatorId(cursor.isNull(offset + 38) ? null : cursor.getString(offset + 38));
        entity.setCreator(cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39));
        entity.setCreateTime(cursor.isNull(offset + 40) ? null : new java.util.Date(cursor.getLong(offset + 40)));
        entity.setModifiedOrgId(cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41));
        entity.setModifiedOrgName(cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42));
        entity.setModifierId(cursor.isNull(offset + 43) ? null : cursor.getString(offset + 43));
        entity.setModifier(cursor.isNull(offset + 44) ? null : cursor.getString(offset + 44));
        entity.setModifiedTime(cursor.isNull(offset + 45) ? null : new java.util.Date(cursor.getLong(offset + 45)));
        entity.setAssessmentCount(cursor.isNull(offset + 46) ? null : cursor.getInt(offset + 46));
        entity.setMissingCount(cursor.isNull(offset + 47) ? null : cursor.getInt(offset + 47));
        entity.setIntactRate(cursor.isNull(offset + 48) ? null : cursor.getDouble(offset + 48));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(DisabilityHearing entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(DisabilityHearing entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}