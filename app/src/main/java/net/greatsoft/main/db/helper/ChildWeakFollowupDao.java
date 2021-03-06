package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.child.ChildWeakFollowup;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHILD_WEAK_FOLLOWUP".
*/
public class ChildWeakFollowupDao extends AbstractDao<ChildWeakFollowup, Void> {

    public static final String TABLENAME = "CHILD_WEAK_FOLLOWUP";

    /**
     * Properties of entity ChildWeakFollowup.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ChildWeakFollowupId = new Property(0, String.class, "childWeakFollowupId", false, "CHILD_WEAK_FOLLOWUP_ID");
        public final static Property PersonInfoId = new Property(1, String.class, "personInfoId", false, "PERSON_INFO_ID");
        public final static Property ChildWeakFollowupFormNo = new Property(2, String.class, "childWeakFollowupFormNo", false, "CHILD_WEAK_FOLLOWUP_FORM_NO");
        public final static Property FollowupDate = new Property(3, java.util.Date.class, "followupDate", false, "FOLLOWUP_DATE");
        public final static Property FollowupDoctor = new Property(4, String.class, "followupDoctor", false, "FOLLOWUP_DOCTOR");
        public final static Property MoonAge = new Property(5, Integer.class, "moonAge", false, "MOON_AGE");
        public final static Property Symptom = new Property(6, String.class, "symptom", false, "SYMPTOM");
        public final static Property ObjectiveSign = new Property(7, String.class, "objectiveSign", false, "OBJECTIVE_SIGN");
        public final static Property Height = new Property(8, Double.class, "height", false, "HEIGHT");
        public final static Property Weight = new Property(9, Double.class, "weight", false, "WEIGHT");
        public final static Property Hb = new Property(10, Integer.class, "hb", false, "HB");
        public final static Property OutdoorExercise = new Property(11, String.class, "outdoorExercise", false, "OUTDOOR_EXERCISE");
        public final static Property EvaluationMethod = new Property(12, String.class, "evaluationMethod", false, "EVALUATION_METHOD");
        public final static Property EvaluationResult = new Property(13, String.class, "evaluationResult", false, "EVALUATION_RESULT");
        public final static Property Problem = new Property(14, String.class, "problem", false, "PROBLEM");
        public final static Property CureSolution = new Property(15, String.class, "cureSolution", false, "CURE_SOLUTION");
        public final static Property ExamItemName = new Property(16, String.class, "examItemName", false, "EXAM_ITEM_NAME");
        public final static Property ExamResult = new Property(17, String.class, "examResult", false, "EXAM_RESULT");
        public final static Property Dispose = new Property(18, String.class, "dispose", false, "DISPOSE");
        public final static Property Guide = new Property(19, String.class, "guide", false, "GUIDE");
        public final static Property PrecontractDate = new Property(20, java.util.Date.class, "precontractDate", false, "PRECONTRACT_DATE");
        public final static Property ConsultationInfo = new Property(21, String.class, "consultationInfo", false, "CONSULTATION_INFO");
        public final static Property TransferInfo = new Property(22, String.class, "transferInfo", false, "TRANSFER_INFO");
        public final static Property CreateDate = new Property(23, java.util.Date.class, "createDate", false, "CREATE_DATE");
        public final static Property IsCancel = new Property(24, Integer.class, "isCancel", false, "IS_CANCEL");
        public final static Property CreateOrgId = new Property(25, String.class, "createOrgId", false, "CREATE_ORG_ID");
        public final static Property OrgName = new Property(26, String.class, "orgName", false, "ORG_NAME");
        public final static Property CreatorId = new Property(27, String.class, "creatorId", false, "CREATOR_ID");
        public final static Property Creator = new Property(28, String.class, "creator", false, "CREATOR");
        public final static Property CreateTime = new Property(29, java.util.Date.class, "createTime", false, "CREATE_TIME");
        public final static Property ModifiedOrgId = new Property(30, String.class, "modifiedOrgId", false, "MODIFIED_ORG_ID");
        public final static Property ModifiedOrgName = new Property(31, String.class, "modifiedOrgName", false, "MODIFIED_ORG_NAME");
        public final static Property ModifierId = new Property(32, String.class, "modifierId", false, "MODIFIER_ID");
        public final static Property Modifier = new Property(33, String.class, "modifier", false, "MODIFIER");
        public final static Property ModifiedTime = new Property(34, java.util.Date.class, "modifiedTime", false, "MODIFIED_TIME");
    };


    public ChildWeakFollowupDao(DaoConfig config) {
        super(config);
    }
    
    public ChildWeakFollowupDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHILD_WEAK_FOLLOWUP\" (" + //
                "\"CHILD_WEAK_FOLLOWUP_ID\" TEXT," + // 0: childWeakFollowupId
                "\"PERSON_INFO_ID\" TEXT," + // 1: personInfoId
                "\"CHILD_WEAK_FOLLOWUP_FORM_NO\" TEXT," + // 2: childWeakFollowupFormNo
                "\"FOLLOWUP_DATE\" INTEGER," + // 3: followupDate
                "\"FOLLOWUP_DOCTOR\" TEXT," + // 4: followupDoctor
                "\"MOON_AGE\" INTEGER," + // 5: moonAge
                "\"SYMPTOM\" TEXT," + // 6: symptom
                "\"OBJECTIVE_SIGN\" TEXT," + // 7: objectiveSign
                "\"HEIGHT\" REAL," + // 8: height
                "\"WEIGHT\" REAL," + // 9: weight
                "\"HB\" INTEGER," + // 10: hb
                "\"OUTDOOR_EXERCISE\" TEXT," + // 11: outdoorExercise
                "\"EVALUATION_METHOD\" TEXT," + // 12: evaluationMethod
                "\"EVALUATION_RESULT\" TEXT," + // 13: evaluationResult
                "\"PROBLEM\" TEXT," + // 14: problem
                "\"CURE_SOLUTION\" TEXT," + // 15: cureSolution
                "\"EXAM_ITEM_NAME\" TEXT," + // 16: examItemName
                "\"EXAM_RESULT\" TEXT," + // 17: examResult
                "\"DISPOSE\" TEXT," + // 18: dispose
                "\"GUIDE\" TEXT," + // 19: guide
                "\"PRECONTRACT_DATE\" INTEGER," + // 20: precontractDate
                "\"CONSULTATION_INFO\" TEXT," + // 21: consultationInfo
                "\"TRANSFER_INFO\" TEXT," + // 22: transferInfo
                "\"CREATE_DATE\" INTEGER," + // 23: createDate
                "\"IS_CANCEL\" INTEGER," + // 24: isCancel
                "\"CREATE_ORG_ID\" TEXT," + // 25: createOrgId
                "\"ORG_NAME\" TEXT," + // 26: orgName
                "\"CREATOR_ID\" TEXT," + // 27: creatorId
                "\"CREATOR\" TEXT," + // 28: creator
                "\"CREATE_TIME\" INTEGER," + // 29: createTime
                "\"MODIFIED_ORG_ID\" TEXT," + // 30: modifiedOrgId
                "\"MODIFIED_ORG_NAME\" TEXT," + // 31: modifiedOrgName
                "\"MODIFIER_ID\" TEXT," + // 32: modifierId
                "\"MODIFIER\" TEXT," + // 33: modifier
                "\"MODIFIED_TIME\" INTEGER);"); // 34: modifiedTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHILD_WEAK_FOLLOWUP\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ChildWeakFollowup entity) {
        stmt.clearBindings();
 
        String childWeakFollowupId = entity.getChildWeakFollowupId();
        if (childWeakFollowupId != null) {
            stmt.bindString(1, childWeakFollowupId);
        }
 
        String personInfoId = entity.getPersonInfoId();
        if (personInfoId != null) {
            stmt.bindString(2, personInfoId);
        }
 
        String childWeakFollowupFormNo = entity.getChildWeakFollowupFormNo();
        if (childWeakFollowupFormNo != null) {
            stmt.bindString(3, childWeakFollowupFormNo);
        }
 
        java.util.Date followupDate = entity.getFollowupDate();
        if (followupDate != null) {
            stmt.bindLong(4, followupDate.getTime());
        }
 
        String followupDoctor = entity.getFollowupDoctor();
        if (followupDoctor != null) {
            stmt.bindString(5, followupDoctor);
        }
 
        Integer moonAge = entity.getMoonAge();
        if (moonAge != null) {
            stmt.bindLong(6, moonAge);
        }
 
        String symptom = entity.getSymptom();
        if (symptom != null) {
            stmt.bindString(7, symptom);
        }
 
        String objectiveSign = entity.getObjectiveSign();
        if (objectiveSign != null) {
            stmt.bindString(8, objectiveSign);
        }
 
        Double height = entity.getHeight();
        if (height != null) {
            stmt.bindDouble(9, height);
        }
 
        Double weight = entity.getWeight();
        if (weight != null) {
            stmt.bindDouble(10, weight);
        }
 
        Integer hb = entity.getHb();
        if (hb != null) {
            stmt.bindLong(11, hb);
        }
 
        String outdoorExercise = entity.getOutdoorExercise();
        if (outdoorExercise != null) {
            stmt.bindString(12, outdoorExercise);
        }
 
        String evaluationMethod = entity.getEvaluationMethod();
        if (evaluationMethod != null) {
            stmt.bindString(13, evaluationMethod);
        }
 
        String evaluationResult = entity.getEvaluationResult();
        if (evaluationResult != null) {
            stmt.bindString(14, evaluationResult);
        }
 
        String problem = entity.getProblem();
        if (problem != null) {
            stmt.bindString(15, problem);
        }
 
        String cureSolution = entity.getCureSolution();
        if (cureSolution != null) {
            stmt.bindString(16, cureSolution);
        }
 
        String examItemName = entity.getExamItemName();
        if (examItemName != null) {
            stmt.bindString(17, examItemName);
        }
 
        String examResult = entity.getExamResult();
        if (examResult != null) {
            stmt.bindString(18, examResult);
        }
 
        String dispose = entity.getDispose();
        if (dispose != null) {
            stmt.bindString(19, dispose);
        }
 
        String guide = entity.getGuide();
        if (guide != null) {
            stmt.bindString(20, guide);
        }
 
        java.util.Date precontractDate = entity.getPrecontractDate();
        if (precontractDate != null) {
            stmt.bindLong(21, precontractDate.getTime());
        }
 
        String consultationInfo = entity.getConsultationInfo();
        if (consultationInfo != null) {
            stmt.bindString(22, consultationInfo);
        }
 
        String transferInfo = entity.getTransferInfo();
        if (transferInfo != null) {
            stmt.bindString(23, transferInfo);
        }
 
        java.util.Date createDate = entity.getCreateDate();
        if (createDate != null) {
            stmt.bindLong(24, createDate.getTime());
        }
 
        Integer isCancel = entity.getIsCancel();
        if (isCancel != null) {
            stmt.bindLong(25, isCancel);
        }
 
        String createOrgId = entity.getCreateOrgId();
        if (createOrgId != null) {
            stmt.bindString(26, createOrgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(27, orgName);
        }
 
        String creatorId = entity.getCreatorId();
        if (creatorId != null) {
            stmt.bindString(28, creatorId);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(29, creator);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(30, createTime.getTime());
        }
 
        String modifiedOrgId = entity.getModifiedOrgId();
        if (modifiedOrgId != null) {
            stmt.bindString(31, modifiedOrgId);
        }
 
        String modifiedOrgName = entity.getModifiedOrgName();
        if (modifiedOrgName != null) {
            stmt.bindString(32, modifiedOrgName);
        }
 
        String modifierId = entity.getModifierId();
        if (modifierId != null) {
            stmt.bindString(33, modifierId);
        }
 
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(34, modifier);
        }
 
        java.util.Date modifiedTime = entity.getModifiedTime();
        if (modifiedTime != null) {
            stmt.bindLong(35, modifiedTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ChildWeakFollowup entity) {
        stmt.clearBindings();
 
        String childWeakFollowupId = entity.getChildWeakFollowupId();
        if (childWeakFollowupId != null) {
            stmt.bindString(1, childWeakFollowupId);
        }
 
        String personInfoId = entity.getPersonInfoId();
        if (personInfoId != null) {
            stmt.bindString(2, personInfoId);
        }
 
        String childWeakFollowupFormNo = entity.getChildWeakFollowupFormNo();
        if (childWeakFollowupFormNo != null) {
            stmt.bindString(3, childWeakFollowupFormNo);
        }
 
        java.util.Date followupDate = entity.getFollowupDate();
        if (followupDate != null) {
            stmt.bindLong(4, followupDate.getTime());
        }
 
        String followupDoctor = entity.getFollowupDoctor();
        if (followupDoctor != null) {
            stmt.bindString(5, followupDoctor);
        }
 
        Integer moonAge = entity.getMoonAge();
        if (moonAge != null) {
            stmt.bindLong(6, moonAge);
        }
 
        String symptom = entity.getSymptom();
        if (symptom != null) {
            stmt.bindString(7, symptom);
        }
 
        String objectiveSign = entity.getObjectiveSign();
        if (objectiveSign != null) {
            stmt.bindString(8, objectiveSign);
        }
 
        Double height = entity.getHeight();
        if (height != null) {
            stmt.bindDouble(9, height);
        }
 
        Double weight = entity.getWeight();
        if (weight != null) {
            stmt.bindDouble(10, weight);
        }
 
        Integer hb = entity.getHb();
        if (hb != null) {
            stmt.bindLong(11, hb);
        }
 
        String outdoorExercise = entity.getOutdoorExercise();
        if (outdoorExercise != null) {
            stmt.bindString(12, outdoorExercise);
        }
 
        String evaluationMethod = entity.getEvaluationMethod();
        if (evaluationMethod != null) {
            stmt.bindString(13, evaluationMethod);
        }
 
        String evaluationResult = entity.getEvaluationResult();
        if (evaluationResult != null) {
            stmt.bindString(14, evaluationResult);
        }
 
        String problem = entity.getProblem();
        if (problem != null) {
            stmt.bindString(15, problem);
        }
 
        String cureSolution = entity.getCureSolution();
        if (cureSolution != null) {
            stmt.bindString(16, cureSolution);
        }
 
        String examItemName = entity.getExamItemName();
        if (examItemName != null) {
            stmt.bindString(17, examItemName);
        }
 
        String examResult = entity.getExamResult();
        if (examResult != null) {
            stmt.bindString(18, examResult);
        }
 
        String dispose = entity.getDispose();
        if (dispose != null) {
            stmt.bindString(19, dispose);
        }
 
        String guide = entity.getGuide();
        if (guide != null) {
            stmt.bindString(20, guide);
        }
 
        java.util.Date precontractDate = entity.getPrecontractDate();
        if (precontractDate != null) {
            stmt.bindLong(21, precontractDate.getTime());
        }
 
        String consultationInfo = entity.getConsultationInfo();
        if (consultationInfo != null) {
            stmt.bindString(22, consultationInfo);
        }
 
        String transferInfo = entity.getTransferInfo();
        if (transferInfo != null) {
            stmt.bindString(23, transferInfo);
        }
 
        java.util.Date createDate = entity.getCreateDate();
        if (createDate != null) {
            stmt.bindLong(24, createDate.getTime());
        }
 
        Integer isCancel = entity.getIsCancel();
        if (isCancel != null) {
            stmt.bindLong(25, isCancel);
        }
 
        String createOrgId = entity.getCreateOrgId();
        if (createOrgId != null) {
            stmt.bindString(26, createOrgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(27, orgName);
        }
 
        String creatorId = entity.getCreatorId();
        if (creatorId != null) {
            stmt.bindString(28, creatorId);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(29, creator);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(30, createTime.getTime());
        }
 
        String modifiedOrgId = entity.getModifiedOrgId();
        if (modifiedOrgId != null) {
            stmt.bindString(31, modifiedOrgId);
        }
 
        String modifiedOrgName = entity.getModifiedOrgName();
        if (modifiedOrgName != null) {
            stmt.bindString(32, modifiedOrgName);
        }
 
        String modifierId = entity.getModifierId();
        if (modifierId != null) {
            stmt.bindString(33, modifierId);
        }
 
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(34, modifier);
        }
 
        java.util.Date modifiedTime = entity.getModifiedTime();
        if (modifiedTime != null) {
            stmt.bindLong(35, modifiedTime.getTime());
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public ChildWeakFollowup readEntity(Cursor cursor, int offset) {
        ChildWeakFollowup entity = new ChildWeakFollowup( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // childWeakFollowupId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // personInfoId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // childWeakFollowupFormNo
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // followupDate
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // followupDoctor
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // moonAge
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // symptom
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // objectiveSign
            cursor.isNull(offset + 8) ? null : cursor.getDouble(offset + 8), // height
            cursor.isNull(offset + 9) ? null : cursor.getDouble(offset + 9), // weight
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // hb
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // outdoorExercise
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // evaluationMethod
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // evaluationResult
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // problem
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // cureSolution
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // examItemName
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // examResult
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // dispose
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // guide
            cursor.isNull(offset + 20) ? null : new java.util.Date(cursor.getLong(offset + 20)), // precontractDate
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // consultationInfo
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // transferInfo
            cursor.isNull(offset + 23) ? null : new java.util.Date(cursor.getLong(offset + 23)), // createDate
            cursor.isNull(offset + 24) ? null : cursor.getInt(offset + 24), // isCancel
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // createOrgId
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // orgName
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // creatorId
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // creator
            cursor.isNull(offset + 29) ? null : new java.util.Date(cursor.getLong(offset + 29)), // createTime
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), // modifiedOrgId
            cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31), // modifiedOrgName
            cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32), // modifierId
            cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33), // modifier
            cursor.isNull(offset + 34) ? null : new java.util.Date(cursor.getLong(offset + 34)) // modifiedTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ChildWeakFollowup entity, int offset) {
        entity.setChildWeakFollowupId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPersonInfoId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setChildWeakFollowupFormNo(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFollowupDate(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setFollowupDoctor(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setMoonAge(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setSymptom(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setObjectiveSign(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setHeight(cursor.isNull(offset + 8) ? null : cursor.getDouble(offset + 8));
        entity.setWeight(cursor.isNull(offset + 9) ? null : cursor.getDouble(offset + 9));
        entity.setHb(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setOutdoorExercise(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setEvaluationMethod(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setEvaluationResult(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setProblem(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setCureSolution(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setExamItemName(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setExamResult(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setDispose(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setGuide(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setPrecontractDate(cursor.isNull(offset + 20) ? null : new java.util.Date(cursor.getLong(offset + 20)));
        entity.setConsultationInfo(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setTransferInfo(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setCreateDate(cursor.isNull(offset + 23) ? null : new java.util.Date(cursor.getLong(offset + 23)));
        entity.setIsCancel(cursor.isNull(offset + 24) ? null : cursor.getInt(offset + 24));
        entity.setCreateOrgId(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setOrgName(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setCreatorId(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setCreator(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setCreateTime(cursor.isNull(offset + 29) ? null : new java.util.Date(cursor.getLong(offset + 29)));
        entity.setModifiedOrgId(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setModifiedOrgName(cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31));
        entity.setModifierId(cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32));
        entity.setModifier(cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33));
        entity.setModifiedTime(cursor.isNull(offset + 34) ? null : new java.util.Date(cursor.getLong(offset + 34)));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(ChildWeakFollowup entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(ChildWeakFollowup entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
