package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.person.MemberMovedLog;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MEMBER_MOVED_LOG".
*/
public class MemberMovedLogDao extends AbstractDao<MemberMovedLog, Void> {

    public static final String TABLENAME = "MEMBER_MOVED_LOG";

    /**
     * Properties of entity MemberMovedLog.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property MemberMovedLogId = new Property(0, String.class, "memberMovedLogId", false, "MEMBER_MOVED_LOG_ID");
        public final static Property FamilyMovedLogId = new Property(1, String.class, "familyMovedLogId", false, "FAMILY_MOVED_LOG_ID");
        public final static Property PersonInfoId = new Property(2, String.class, "personInfoId", false, "PERSON_INFO_ID");
        public final static Property FamilyInfoId = new Property(3, String.class, "familyInfoId", false, "FAMILY_INFO_ID");
        public final static Property DistrictId = new Property(4, String.class, "districtId", false, "DISTRICT_ID");
        public final static Property SubDistrictId = new Property(5, String.class, "subDistrictId", false, "SUB_DISTRICT_ID");
        public final static Property BuildingId = new Property(6, String.class, "buildingId", false, "BUILDING_ID");
        public final static Property OperType = new Property(7, Integer.class, "operType", false, "OPER_TYPE");
        public final static Property CreateOrgId = new Property(8, String.class, "createOrgId", false, "CREATE_ORG_ID");
        public final static Property OrgName = new Property(9, String.class, "orgName", false, "ORG_NAME");
        public final static Property CreatorId = new Property(10, String.class, "creatorId", false, "CREATOR_ID");
        public final static Property Creator = new Property(11, String.class, "creator", false, "CREATOR");
        public final static Property CreateTime = new Property(12, java.util.Date.class, "createTime", false, "CREATE_TIME");
    };


    public MemberMovedLogDao(DaoConfig config) {
        super(config);
    }
    
    public MemberMovedLogDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MEMBER_MOVED_LOG\" (" + //
                "\"MEMBER_MOVED_LOG_ID\" TEXT," + // 0: memberMovedLogId
                "\"FAMILY_MOVED_LOG_ID\" TEXT," + // 1: familyMovedLogId
                "\"PERSON_INFO_ID\" TEXT," + // 2: personInfoId
                "\"FAMILY_INFO_ID\" TEXT," + // 3: familyInfoId
                "\"DISTRICT_ID\" TEXT," + // 4: districtId
                "\"SUB_DISTRICT_ID\" TEXT," + // 5: subDistrictId
                "\"BUILDING_ID\" TEXT," + // 6: buildingId
                "\"OPER_TYPE\" INTEGER," + // 7: operType
                "\"CREATE_ORG_ID\" TEXT," + // 8: createOrgId
                "\"ORG_NAME\" TEXT," + // 9: orgName
                "\"CREATOR_ID\" TEXT," + // 10: creatorId
                "\"CREATOR\" TEXT," + // 11: creator
                "\"CREATE_TIME\" INTEGER);"); // 12: createTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MEMBER_MOVED_LOG\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MemberMovedLog entity) {
        stmt.clearBindings();
 
        String memberMovedLogId = entity.getMemberMovedLogId();
        if (memberMovedLogId != null) {
            stmt.bindString(1, memberMovedLogId);
        }
 
        String familyMovedLogId = entity.getFamilyMovedLogId();
        if (familyMovedLogId != null) {
            stmt.bindString(2, familyMovedLogId);
        }
 
        String personInfoId = entity.getPersonInfoId();
        if (personInfoId != null) {
            stmt.bindString(3, personInfoId);
        }
 
        String familyInfoId = entity.getFamilyInfoId();
        if (familyInfoId != null) {
            stmt.bindString(4, familyInfoId);
        }
 
        String districtId = entity.getDistrictId();
        if (districtId != null) {
            stmt.bindString(5, districtId);
        }
 
        String subDistrictId = entity.getSubDistrictId();
        if (subDistrictId != null) {
            stmt.bindString(6, subDistrictId);
        }
 
        String buildingId = entity.getBuildingId();
        if (buildingId != null) {
            stmt.bindString(7, buildingId);
        }
 
        Integer operType = entity.getOperType();
        if (operType != null) {
            stmt.bindLong(8, operType);
        }
 
        String createOrgId = entity.getCreateOrgId();
        if (createOrgId != null) {
            stmt.bindString(9, createOrgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(10, orgName);
        }
 
        String creatorId = entity.getCreatorId();
        if (creatorId != null) {
            stmt.bindString(11, creatorId);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(12, creator);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(13, createTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MemberMovedLog entity) {
        stmt.clearBindings();
 
        String memberMovedLogId = entity.getMemberMovedLogId();
        if (memberMovedLogId != null) {
            stmt.bindString(1, memberMovedLogId);
        }
 
        String familyMovedLogId = entity.getFamilyMovedLogId();
        if (familyMovedLogId != null) {
            stmt.bindString(2, familyMovedLogId);
        }
 
        String personInfoId = entity.getPersonInfoId();
        if (personInfoId != null) {
            stmt.bindString(3, personInfoId);
        }
 
        String familyInfoId = entity.getFamilyInfoId();
        if (familyInfoId != null) {
            stmt.bindString(4, familyInfoId);
        }
 
        String districtId = entity.getDistrictId();
        if (districtId != null) {
            stmt.bindString(5, districtId);
        }
 
        String subDistrictId = entity.getSubDistrictId();
        if (subDistrictId != null) {
            stmt.bindString(6, subDistrictId);
        }
 
        String buildingId = entity.getBuildingId();
        if (buildingId != null) {
            stmt.bindString(7, buildingId);
        }
 
        Integer operType = entity.getOperType();
        if (operType != null) {
            stmt.bindLong(8, operType);
        }
 
        String createOrgId = entity.getCreateOrgId();
        if (createOrgId != null) {
            stmt.bindString(9, createOrgId);
        }
 
        String orgName = entity.getOrgName();
        if (orgName != null) {
            stmt.bindString(10, orgName);
        }
 
        String creatorId = entity.getCreatorId();
        if (creatorId != null) {
            stmt.bindString(11, creatorId);
        }
 
        String creator = entity.getCreator();
        if (creator != null) {
            stmt.bindString(12, creator);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(13, createTime.getTime());
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public MemberMovedLog readEntity(Cursor cursor, int offset) {
        MemberMovedLog entity = new MemberMovedLog( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // memberMovedLogId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // familyMovedLogId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // personInfoId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // familyInfoId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // districtId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // subDistrictId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // buildingId
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // operType
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // createOrgId
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // orgName
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // creatorId
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // creator
            cursor.isNull(offset + 12) ? null : new java.util.Date(cursor.getLong(offset + 12)) // createTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MemberMovedLog entity, int offset) {
        entity.setMemberMovedLogId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setFamilyMovedLogId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPersonInfoId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFamilyInfoId(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDistrictId(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSubDistrictId(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setBuildingId(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setOperType(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setCreateOrgId(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setOrgName(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setCreatorId(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setCreator(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setCreateTime(cursor.isNull(offset + 12) ? null : new java.util.Date(cursor.getLong(offset + 12)));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(MemberMovedLog entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(MemberMovedLog entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
