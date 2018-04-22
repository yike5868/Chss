package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.UpdateState;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "UPDATE_STATE".
*/
public class UpdateStateDao extends AbstractDao<UpdateState, Void> {

    public static final String TABLENAME = "UPDATE_STATE";

    /**
     * Properties of entity UpdateState.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property TableKey = new Property(0, String.class, "tableKey", false, "TABLE_KEY");
        public final static Property TableType = new Property(1, String.class, "tableType", false, "TABLE_TYPE");
        public final static Property TableState = new Property(2, Integer.class, "tableState", false, "TABLE_STATE");
        public final static Property TableReson = new Property(3, String.class, "tableReson", false, "TABLE_RESON");
        public final static Property Name = new Property(4, String.class, "name", false, "NAME");
        public final static Property Time = new Property(5, String.class, "time", false, "TIME");
    };


    public UpdateStateDao(DaoConfig config) {
        super(config);
    }
    
    public UpdateStateDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"UPDATE_STATE\" (" + //
                "\"TABLE_KEY\" TEXT," + // 0: tableKey
                "\"TABLE_TYPE\" TEXT," + // 1: tableType
                "\"TABLE_STATE\" INTEGER," + // 2: tableState
                "\"TABLE_RESON\" TEXT," + // 3: tableReson
                "\"NAME\" TEXT," + // 4: name
                "\"TIME\" TEXT);"); // 5: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"UPDATE_STATE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UpdateState entity) {
        stmt.clearBindings();
 
        String tableKey = entity.getTableKey();
        if (tableKey != null) {
            stmt.bindString(1, tableKey);
        }
 
        String tableType = entity.getTableType();
        if (tableType != null) {
            stmt.bindString(2, tableType);
        }
 
        Integer tableState = entity.getTableState();
        if (tableState != null) {
            stmt.bindLong(3, tableState);
        }
 
        String tableReson = entity.getTableReson();
        if (tableReson != null) {
            stmt.bindString(4, tableReson);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(6, time);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UpdateState entity) {
        stmt.clearBindings();
 
        String tableKey = entity.getTableKey();
        if (tableKey != null) {
            stmt.bindString(1, tableKey);
        }
 
        String tableType = entity.getTableType();
        if (tableType != null) {
            stmt.bindString(2, tableType);
        }
 
        Integer tableState = entity.getTableState();
        if (tableState != null) {
            stmt.bindLong(3, tableState);
        }
 
        String tableReson = entity.getTableReson();
        if (tableReson != null) {
            stmt.bindString(4, tableReson);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(6, time);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public UpdateState readEntity(Cursor cursor, int offset) {
        UpdateState entity = new UpdateState( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // tableKey
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // tableType
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // tableState
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // tableReson
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // name
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // time
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UpdateState entity, int offset) {
        entity.setTableKey(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTableType(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTableState(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setTableReson(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(UpdateState entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(UpdateState entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
