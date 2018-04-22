package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.old.ElderInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ELDER_INFO".
*/
public class ElderInfoDao extends AbstractDao<ElderInfo, Void> {

    public static final String TABLENAME = "ELDER_INFO";

    /**
     * Properties of entity ElderInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ElderInfoId = new Property(0, String.class, "elderInfoId", false, "ELDER_INFO_ID");
        public final static Property PersonInfoId = new Property(1, String.class, "personInfoId", false, "PERSON_INFO_ID");
        public final static Property ManageOrgId = new Property(2, String.class, "manageOrgId", false, "MANAGE_ORG_ID");
        public final static Property Name = new Property(3, String.class, "name", false, "NAME");
        public final static Property MaintenanceModeCode = new Property(4, String.class, "maintenanceModeCode", false, "MAINTENANCE_MODE_CODE");
        public final static Property GuardianName = new Property(5, String.class, "guardianName", false, "GUARDIAN_NAME");
        public final static Property GuardianRelationCode = new Property(6, String.class, "guardianRelationCode", false, "GUARDIAN_RELATION_CODE");
        public final static Property GuardianAddr = new Property(7, String.class, "guardianAddr", false, "GUARDIAN_ADDR");
        public final static Property GuardianTelNo = new Property(8, String.class, "guardianTelNo", false, "GUARDIAN_TEL_NO");
        public final static Property GuardianMobile = new Property(9, String.class, "guardianMobile", false, "GUARDIAN_MOBILE");
        public final static Property Informant = new Property(10, String.class, "informant", false, "INFORMANT");
        public final static Property InformantDate = new Property(11, java.util.Date.class, "informantDate", false, "INFORMANT_DATE");
        public final static Property Investigator = new Property(12, String.class, "investigator", false, "INVESTIGATOR");
        public final static Property InvestigatorDate = new Property(13, java.util.Date.class, "investigatorDate", false, "INVESTIGATOR_DATE");
        public final static Property ManageDate = new Property(14, java.util.Date.class, "manageDate", false, "MANAGE_DATE");
        public final static Property Remarks = new Property(15, String.class, "remarks", false, "REMARKS");
        public final static Property IsCancel = new Property(16, Integer.class, "isCancel", false, "IS_CANCEL");
        public final static Property CreateOrgId = new Property(17, String.class, "createOrgId", false, "CREATE_ORG_ID");
        public final static Property OrgName = new Property(18, String.class, "orgName", false, "ORG_NAME");
        public final static Property CreatorId = new Property(19, String.class, "creatorId", false, "CREATOR_ID");
        public final static Property Creator = new Property(20, String.class, "creator", false, "CREATOR");
        public final static Property CreateTime = new Property(21, java.util.Date.class, "createTime", false, "CREATE_TIME");
        public final static Property ModifiedOrgId = new Property(22, String.class, "modifiedOrgId", false, "MODIFIED_ORG_ID");
        public final static Property ModifiedOrgName = new Property(23, String.class, "modifiedOrgName", false, "MODIFIED_ORG_NAME");
        public final static Property ModifierId = new Property(24, String.class, "modifierId", false, "MODIFIER_ID");
        public final static Property Modifier = new Property(25, String.class, "modifier", false, "MODIFIER");
        public final static Property ModifiedTime = new Property(26, java.util.Date.class, "modifiedTime", false, "MODIFIED_TIME");
    };


    public ElderInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ElderInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ELDER_INFO\" (" + //
                "\"ELDER_INFO_ID\" TEXT," + // 0: elderInfoId
                "\"PERSON_INFO_ID\" TEXT," + // 1: personInfoId
                "\"MANAGE_ORG_ID\" TEXT," + // 2: manageOrgId
                "\"NAME\" TEXT," + // 3: name
                "\"MAINTENANCE_MODE_CODE\" TEXT," + // 4: maintenanceModeCode
                "\"GUARDIAN_NAME\" TEXT," + // 5: guardianName
                "\"GUARDIAN_RELATION_CODE\" TEXT," + // 6: guardianRelationCode
                "\"GUARDIAN_ADDR\" TEXT," + // 7: guardianAddr
                "\"GUARDIAN_TEL_NO\" TEXT," + // 8: guardianTelNo
                "\"GUARDIAN_MOBILE\" TEXT," + // 9: guardianMobile
                "\"INFORMANT\" TEXT," + // 10: informant
                "\"INFORMANT_DATE\" INTEGER," + // 11: informantDate
                "\"INVESTIGATOR\" TEXT," + // 12: investigator
                "\"INVESTIGATOR_DATE\" INTEGER," + // 13: investigatorDate
                "\"MANAGE_DATE\" INTEGER," + // 14: manageDate
                "\"REMARKS\" TEXT," + // 15: remarks
                "\"IS_CANCEL\" INTEGER," + // 16: isCancel
                "\"CREATE_ORG_ID\" TEXT," + // 17: createOrgId
                "\"ORG_NAME\" TEXT," + // 18: orgName
                "\"CREATOR_ID\" TEXT," + // 19: creatorId
                "\"CREATOR\" TEXT," + // 20: creator
                "\"CREATE_TIME\" INTEGER," + // 21: createTime
                "\"MODIFIED_ORG_ID\" TEXT," + // 22: modifiedOrgId
                "\"MODIFIED_ORG_NAME\" TEXT," + // 23: modifiedOrgName
                "\"MODIFIER_ID\" TEXT," + // 24: modifierId
                "\"MODIFIER\" TEXT," + // 25: modifier
                "\"MODIFIED_TIME\" INTEGER);"); // 26: modifiedTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ELDER_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ElderInfo entity) {
        stmt.clearBindings();
 
        String elderInfoId = entity.getElderInfoId();
        if (elderInfoId != null) {
            stmt.bindString(1, elderInfoId);
        }
 
        String personInfoId = entity.getPersonInfoId();
        if (personInfoId != null) {
            stmt.bindString(2, personInfoId);
        }
 
        String manageOrgId = entity.getManageOrgId();
        if (manageOrgId != null) {
            stmt.bindString(3, manageOrgId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        String maintenanceModeCode = entity.getMaintenanceModeCode();
        if (maintenanceModeCode != null) {
            stmt.bindString(5, maintenanceModeCode);
        }
 
        String guardianName = entity.getGuardianName();
        if (guardianName != null) {
            stmt.bindString(6, guardianName);
        }
 
        String guardianRelationCode = entity.getGuardianRelationCode();
        if (guardianRelationCode != null) {
            stmt.bindString(7, guardianRelationCode);
        }
 
        String guardianAddr = entity.getGuardianAddr();
        if (guardianAddr != null) {
            stmt.bindString(8, guardianAddr);
        }
 
        String guardianTelNo = entity.getGuardianTelNo();
        if (guardianTelNo != null) {
            stmt.bindString(9, guardianTelNo);
        }
 
        String guardianMobile = entity.getGuardianMobile();
        if (guardianMobile != null) {
            stmt.bindString(10, guardianMobile);
        }
 
        String informant = entity.getInformant();
        if (informant != null) {
            stmt.bindString(11, informant);
        }
 
        java.util.Date informantDate = entity.getInformantDate();
        if (informantDate != null) {
            stmt.bindLong(12, informantDate.getTime());
        }
 
        String investigator = entity.getInvestigator();
        if (investigator != null) {
            stmt.bindString(13, investigator);
        }
 
        java.util.Date investigatorDate = entity.getInvestigatorDate();
        if (investigatorDate != null) {
            stmt.bindLong(14, investigatorDate.getTime());
        }
 
        java.util.Date manageDate = entity.getManageDate();
        if (manageDate != null) {
            stmt.bindLong(15, manageDate.getTime());
        }
 
        String remarks = entity.getRemarks();
        if (remarks != null) {
            stmt.bindString(16, remarks);
        }
 
        Integer isCancel = entity.getIsCancel();
        if (isCancel != null) {
            stmt.bindLong(17, isCancel);
        }
 
        String createOrgId = entity.getCreateOrgId();
        if (createOrgId != null) {
            stmt.bindString(18, createOrgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(19, orgName);
        }
 
        String creatorId = entity.getCreatorId();
        if (creatorId != null) {
            stmt.bindString(20, creatorId);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(21, creator);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(22, createTime.getTime());
        }
 
        String modifiedOrgId = entity.getModifiedOrgId();
        if (modifiedOrgId != null) {
            stmt.bindString(23, modifiedOrgId);
        }
 
        String modifiedOrgName = entity.getModifiedOrgName();
        if (modifiedOrgName != null) {
            stmt.bindString(24, modifiedOrgName);
        }
 
        String modifierId = entity.getModifierId();
        if (modifierId != null) {
            stmt.bindString(25, modifierId);
        }
 
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(26, modifier);
        }
 
        java.util.Date modifiedTime = entity.getModifiedTime();
        if (modifiedTime != null) {
            stmt.bindLong(27, modifiedTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ElderInfo entity) {
        stmt.clearBindings();
 
        String elderInfoId = entity.getElderInfoId();
        if (elderInfoId != null) {
            stmt.bindString(1, elderInfoId);
        }
 
        String personInfoId = entity.getPersonInfoId();
        if (personInfoId != null) {
            stmt.bindString(2, personInfoId);
        }
 
        String manageOrgId = entity.getManageOrgId();
        if (manageOrgId != null) {
            stmt.bindString(3, manageOrgId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
 
        String maintenanceModeCode = entity.getMaintenanceModeCode();
        if (maintenanceModeCode != null) {
            stmt.bindString(5, maintenanceModeCode);
        }
 
        String guardianName = entity.getGuardianName();
        if (guardianName != null) {
            stmt.bindString(6, guardianName);
        }
 
        String guardianRelationCode = entity.getGuardianRelationCode();
        if (guardianRelationCode != null) {
            stmt.bindString(7, guardianRelationCode);
        }
 
        String guardianAddr = entity.getGuardianAddr();
        if (guardianAddr != null) {
            stmt.bindString(8, guardianAddr);
        }
 
        String guardianTelNo = entity.getGuardianTelNo();
        if (guardianTelNo != null) {
            stmt.bindString(9, guardianTelNo);
        }
 
        String guardianMobile = entity.getGuardianMobile();
        if (guardianMobile != null) {
            stmt.bindString(10, guardianMobile);
        }
 
        String informant = entity.getInformant();
        if (informant != null) {
            stmt.bindString(11, informant);
        }
 
        java.util.Date informantDate = entity.getInformantDate();
        if (informantDate != null) {
            stmt.bindLong(12, informantDate.getTime());
        }
 
        String investigator = entity.getInvestigator();
        if (investigator != null) {
            stmt.bindString(13, investigator);
        }
 
        java.util.Date investigatorDate = entity.getInvestigatorDate();
        if (investigatorDate != null) {
            stmt.bindLong(14, investigatorDate.getTime());
        }
 
        java.util.Date manageDate = entity.getManageDate();
        if (manageDate != null) {
            stmt.bindLong(15, manageDate.getTime());
        }
 
        String remarks = entity.getRemarks();
        if (remarks != null) {
            stmt.bindString(16, remarks);
        }
 
        Integer isCancel = entity.getIsCancel();
        if (isCancel != null) {
            stmt.bindLong(17, isCancel);
        }
 
        String createOrgId = entity.getCreateOrgId();
        if (createOrgId != null) {
            stmt.bindString(18, createOrgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(19, orgName);
        }
 
        String creatorId = entity.getCreatorId();
        if (creatorId != null) {
            stmt.bindString(20, creatorId);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(21, creator);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(22, createTime.getTime());
        }
 
        String modifiedOrgId = entity.getModifiedOrgId();
        if (modifiedOrgId != null) {
            stmt.bindString(23, modifiedOrgId);
        }
 
        String modifiedOrgName = entity.getModifiedOrgName();
        if (modifiedOrgName != null) {
            stmt.bindString(24, modifiedOrgName);
        }
 
        String modifierId = entity.getModifierId();
        if (modifierId != null) {
            stmt.bindString(25, modifierId);
        }
 
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(26, modifier);
        }
 
        java.util.Date modifiedTime = entity.getModifiedTime();
        if (modifiedTime != null) {
            stmt.bindLong(27, modifiedTime.getTime());
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public ElderInfo readEntity(Cursor cursor, int offset) {
        ElderInfo entity = new ElderInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // elderInfoId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // personInfoId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // manageOrgId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // maintenanceModeCode
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // guardianName
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // guardianRelationCode
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // guardianAddr
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // guardianTelNo
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // guardianMobile
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // informant
            cursor.isNull(offset + 11) ? null : new java.util.Date(cursor.getLong(offset + 11)), // informantDate
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // investigator
            cursor.isNull(offset + 13) ? null : new java.util.Date(cursor.getLong(offset + 13)), // investigatorDate
            cursor.isNull(offset + 14) ? null : new java.util.Date(cursor.getLong(offset + 14)), // manageDate
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // remarks
            cursor.isNull(offset + 16) ? null : cursor.getInt(offset + 16), // isCancel
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // createOrgId
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // orgName
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // creatorId
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // creator
            cursor.isNull(offset + 21) ? null : new java.util.Date(cursor.getLong(offset + 21)), // createTime
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // modifiedOrgId
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // modifiedOrgName
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // modifierId
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // modifier
            cursor.isNull(offset + 26) ? null : new java.util.Date(cursor.getLong(offset + 26)) // modifiedTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ElderInfo entity, int offset) {
        entity.setElderInfoId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPersonInfoId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setManageOrgId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMaintenanceModeCode(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setGuardianName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setGuardianRelationCode(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setGuardianAddr(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setGuardianTelNo(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setGuardianMobile(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setInformant(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setInformantDate(cursor.isNull(offset + 11) ? null : new java.util.Date(cursor.getLong(offset + 11)));
        entity.setInvestigator(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setInvestigatorDate(cursor.isNull(offset + 13) ? null : new java.util.Date(cursor.getLong(offset + 13)));
        entity.setManageDate(cursor.isNull(offset + 14) ? null : new java.util.Date(cursor.getLong(offset + 14)));
        entity.setRemarks(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setIsCancel(cursor.isNull(offset + 16) ? null : cursor.getInt(offset + 16));
        entity.setCreateOrgId(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setOrgName(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setCreatorId(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setCreator(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setCreateTime(cursor.isNull(offset + 21) ? null : new java.util.Date(cursor.getLong(offset + 21)));
        entity.setModifiedOrgId(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setModifiedOrgName(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setModifierId(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setModifier(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setModifiedTime(cursor.isNull(offset + 26) ? null : new java.util.Date(cursor.getLong(offset + 26)));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(ElderInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(ElderInfo entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
