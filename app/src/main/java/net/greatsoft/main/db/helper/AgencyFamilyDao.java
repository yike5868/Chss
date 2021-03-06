package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.family.AgencyFamily;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "AGENCY_FAMILY".
*/
public class AgencyFamilyDao extends AbstractDao<AgencyFamily, Void> {

    public static final String TABLENAME = "AGENCY_FAMILY";

    /**
     * Properties of entity AgencyFamily.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property AgencyFamilyId = new Property(0, String.class, "agencyFamilyId", false, "AGENCY_FAMILY_ID");
        public final static Property FamilyInfoId = new Property(1, String.class, "familyInfoId", false, "FAMILY_INFO_ID");
        public final static Property MoveBeforeOrgId = new Property(2, String.class, "moveBeforeOrgId", false, "MOVE_BEFORE_ORG_ID");
        public final static Property MoveAfterOrgId = new Property(3, String.class, "moveAfterOrgId", false, "MOVE_AFTER_ORG_ID");
        public final static Property MoveInDate = new Property(4, java.util.Date.class, "moveInDate", false, "MOVE_IN_DATE");
        public final static Property MoveOutDate = new Property(5, java.util.Date.class, "moveOutDate", false, "MOVE_OUT_DATE");
        public final static Property MoveInReason = new Property(6, Integer.class, "moveInReason", false, "MOVE_IN_REASON");
        public final static Property MoveOutReason = new Property(7, Integer.class, "moveOutReason", false, "MOVE_OUT_REASON");
        public final static Property MoveInOrgId = new Property(8, String.class, "moveInOrgId", false, "MOVE_IN_ORG_ID");
        public final static Property MoveInOrgName = new Property(9, String.class, "moveInOrgName", false, "MOVE_IN_ORG_NAME");
        public final static Property MoveInCreatorId = new Property(10, String.class, "moveInCreatorId", false, "MOVE_IN_CREATOR_ID");
        public final static Property MoveInCreator = new Property(11, String.class, "moveInCreator", false, "MOVE_IN_CREATOR");
        public final static Property MoveInTime = new Property(12, java.util.Date.class, "moveInTime", false, "MOVE_IN_TIME");
        public final static Property MoveOutOrgId = new Property(13, String.class, "moveOutOrgId", false, "MOVE_OUT_ORG_ID");
        public final static Property MoveOutOrgName = new Property(14, String.class, "moveOutOrgName", false, "MOVE_OUT_ORG_NAME");
        public final static Property MoveOutCreatorId = new Property(15, String.class, "moveOutCreatorId", false, "MOVE_OUT_CREATOR_ID");
        public final static Property MoveOutCreator = new Property(16, String.class, "moveOutCreator", false, "MOVE_OUT_CREATOR");
        public final static Property MoveOutTime = new Property(17, java.util.Date.class, "moveOutTime", false, "MOVE_OUT_TIME");
    };


    public AgencyFamilyDao(DaoConfig config) {
        super(config);
    }
    
    public AgencyFamilyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"AGENCY_FAMILY\" (" + //
                "\"AGENCY_FAMILY_ID\" TEXT," + // 0: agencyFamilyId
                "\"FAMILY_INFO_ID\" TEXT," + // 1: familyInfoId
                "\"MOVE_BEFORE_ORG_ID\" TEXT," + // 2: moveBeforeOrgId
                "\"MOVE_AFTER_ORG_ID\" TEXT," + // 3: moveAfterOrgId
                "\"MOVE_IN_DATE\" INTEGER," + // 4: moveInDate
                "\"MOVE_OUT_DATE\" INTEGER," + // 5: moveOutDate
                "\"MOVE_IN_REASON\" INTEGER," + // 6: moveInReason
                "\"MOVE_OUT_REASON\" INTEGER," + // 7: moveOutReason
                "\"MOVE_IN_ORG_ID\" TEXT," + // 8: moveInOrgId
                "\"MOVE_IN_ORG_NAME\" TEXT," + // 9: moveInOrgName
                "\"MOVE_IN_CREATOR_ID\" TEXT," + // 10: moveInCreatorId
                "\"MOVE_IN_CREATOR\" TEXT," + // 11: moveInCreator
                "\"MOVE_IN_TIME\" INTEGER," + // 12: moveInTime
                "\"MOVE_OUT_ORG_ID\" TEXT," + // 13: moveOutOrgId
                "\"MOVE_OUT_ORG_NAME\" TEXT," + // 14: moveOutOrgName
                "\"MOVE_OUT_CREATOR_ID\" TEXT," + // 15: moveOutCreatorId
                "\"MOVE_OUT_CREATOR\" TEXT," + // 16: moveOutCreator
                "\"MOVE_OUT_TIME\" INTEGER);"); // 17: moveOutTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"AGENCY_FAMILY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AgencyFamily entity) {
        stmt.clearBindings();
 
        String agencyFamilyId = entity.getAgencyFamilyId();
        if (agencyFamilyId != null) {
            stmt.bindString(1, agencyFamilyId);
        }
 
        String familyInfoId = entity.getFamilyInfoId();
        if (familyInfoId != null) {
            stmt.bindString(2, familyInfoId);
        }
 
        String moveBeforeOrgId = entity.getMoveBeforeOrgId();
        if (moveBeforeOrgId != null) {
            stmt.bindString(3, moveBeforeOrgId);
        }
 
        String moveAfterOrgId = entity.getMoveAfterOrgId();
        if (moveAfterOrgId != null) {
            stmt.bindString(4, moveAfterOrgId);
        }
 
        java.util.Date moveInDate = entity.getMoveInDate();
        if (moveInDate != null) {
            stmt.bindLong(5, moveInDate.getTime());
        }
 
        java.util.Date moveOutDate = entity.getMoveOutDate();
        if (moveOutDate != null) {
            stmt.bindLong(6, moveOutDate.getTime());
        }
 
        Integer moveInReason = entity.getMoveInReason();
        if (moveInReason != null) {
            stmt.bindLong(7, moveInReason);
        }
 
        Integer moveOutReason = entity.getMoveOutReason();
        if (moveOutReason != null) {
            stmt.bindLong(8, moveOutReason);
        }
 
        String moveInOrgId = entity.getMoveInOrgId();
        if (moveInOrgId != null) {
            stmt.bindString(9, moveInOrgId);
        }
 
        String moveInOrgName = entity.getMoveInOrgName();
        if (moveInOrgName != null) {
            stmt.bindString(10, moveInOrgName);
        }
 
        String moveInCreatorId = entity.getMoveInCreatorId();
        if (moveInCreatorId != null) {
            stmt.bindString(11, moveInCreatorId);
        }
 
        String moveInCreator = entity.getMoveInCreator();
        if (moveInCreator != null) {
            stmt.bindString(12, moveInCreator);
        }
 
        java.util.Date moveInTime = entity.getMoveInTime();
        if (moveInTime != null) {
            stmt.bindLong(13, moveInTime.getTime());
        }
 
        String moveOutOrgId = entity.getMoveOutOrgId();
        if (moveOutOrgId != null) {
            stmt.bindString(14, moveOutOrgId);
        }
 
        String moveOutOrgName = entity.getMoveOutOrgName();
        if (moveOutOrgName != null) {
            stmt.bindString(15, moveOutOrgName);
        }
 
        String moveOutCreatorId = entity.getMoveOutCreatorId();
        if (moveOutCreatorId != null) {
            stmt.bindString(16, moveOutCreatorId);
        }
 
        String moveOutCreator = entity.getMoveOutCreator();
        if (moveOutCreator != null) {
            stmt.bindString(17, moveOutCreator);
        }
 
        java.util.Date moveOutTime = entity.getMoveOutTime();
        if (moveOutTime != null) {
            stmt.bindLong(18, moveOutTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AgencyFamily entity) {
        stmt.clearBindings();
 
        String agencyFamilyId = entity.getAgencyFamilyId();
        if (agencyFamilyId != null) {
            stmt.bindString(1, agencyFamilyId);
        }
 
        String familyInfoId = entity.getFamilyInfoId();
        if (familyInfoId != null) {
            stmt.bindString(2, familyInfoId);
        }
 
        String moveBeforeOrgId = entity.getMoveBeforeOrgId();
        if (moveBeforeOrgId != null) {
            stmt.bindString(3, moveBeforeOrgId);
        }
 
        String moveAfterOrgId = entity.getMoveAfterOrgId();
        if (moveAfterOrgId != null) {
            stmt.bindString(4, moveAfterOrgId);
        }
 
        java.util.Date moveInDate = entity.getMoveInDate();
        if (moveInDate != null) {
            stmt.bindLong(5, moveInDate.getTime());
        }
 
        java.util.Date moveOutDate = entity.getMoveOutDate();
        if (moveOutDate != null) {
            stmt.bindLong(6, moveOutDate.getTime());
        }
 
        Integer moveInReason = entity.getMoveInReason();
        if (moveInReason != null) {
            stmt.bindLong(7, moveInReason);
        }
 
        Integer moveOutReason = entity.getMoveOutReason();
        if (moveOutReason != null) {
            stmt.bindLong(8, moveOutReason);
        }
 
        String moveInOrgId = entity.getMoveInOrgId();
        if (moveInOrgId != null) {
            stmt.bindString(9, moveInOrgId);
        }
 
        String moveInOrgName = entity.getMoveInOrgName();
        if (moveInOrgName != null) {
            stmt.bindString(10, moveInOrgName);
        }
 
        String moveInCreatorId = entity.getMoveInCreatorId();
        if (moveInCreatorId != null) {
            stmt.bindString(11, moveInCreatorId);
        }
 
        String moveInCreator = entity.getMoveInCreator();
        if (moveInCreator != null) {
            stmt.bindString(12, moveInCreator);
        }
 
        java.util.Date moveInTime = entity.getMoveInTime();
        if (moveInTime != null) {
            stmt.bindLong(13, moveInTime.getTime());
        }
 
        String moveOutOrgId = entity.getMoveOutOrgId();
        if (moveOutOrgId != null) {
            stmt.bindString(14, moveOutOrgId);
        }
 
        String moveOutOrgName = entity.getMoveOutOrgName();
        if (moveOutOrgName != null) {
            stmt.bindString(15, moveOutOrgName);
        }
 
        String moveOutCreatorId = entity.getMoveOutCreatorId();
        if (moveOutCreatorId != null) {
            stmt.bindString(16, moveOutCreatorId);
        }
 
        String moveOutCreator = entity.getMoveOutCreator();
        if (moveOutCreator != null) {
            stmt.bindString(17, moveOutCreator);
        }
 
        java.util.Date moveOutTime = entity.getMoveOutTime();
        if (moveOutTime != null) {
            stmt.bindLong(18, moveOutTime.getTime());
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public AgencyFamily readEntity(Cursor cursor, int offset) {
        AgencyFamily entity = new AgencyFamily( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // agencyFamilyId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // familyInfoId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // moveBeforeOrgId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // moveAfterOrgId
            cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)), // moveInDate
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // moveOutDate
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // moveInReason
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // moveOutReason
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // moveInOrgId
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // moveInOrgName
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // moveInCreatorId
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // moveInCreator
            cursor.isNull(offset + 12) ? null : new java.util.Date(cursor.getLong(offset + 12)), // moveInTime
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // moveOutOrgId
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // moveOutOrgName
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // moveOutCreatorId
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // moveOutCreator
            cursor.isNull(offset + 17) ? null : new java.util.Date(cursor.getLong(offset + 17)) // moveOutTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AgencyFamily entity, int offset) {
        entity.setAgencyFamilyId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setFamilyInfoId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMoveBeforeOrgId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMoveAfterOrgId(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMoveInDate(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
        entity.setMoveOutDate(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setMoveInReason(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setMoveOutReason(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setMoveInOrgId(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setMoveInOrgName(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setMoveInCreatorId(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setMoveInCreator(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setMoveInTime(cursor.isNull(offset + 12) ? null : new java.util.Date(cursor.getLong(offset + 12)));
        entity.setMoveOutOrgId(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setMoveOutOrgName(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setMoveOutCreatorId(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setMoveOutCreator(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setMoveOutTime(cursor.isNull(offset + 17) ? null : new java.util.Date(cursor.getLong(offset + 17)));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(AgencyFamily entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(AgencyFamily entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
