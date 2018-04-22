package net.greatsoft.main.db.helper;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import net.greatsoft.main.db.po.Term;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TERM".
*/
public class TermDao extends AbstractDao<Term, Void> {

    public static final String TABLENAME = "TERM";

    /**
     * Properties of entity Term.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Term_version = new Property(0, String.class, "term_version", false, "TERM_VERSION");
        public final static Property Term_pinyin = new Property(1, String.class, "term_pinyin", false, "TERM_PINYIN");
        public final static Property Term_name = new Property(2, String.class, "term_name", false, "TERM_NAME");
        public final static Property Term_priority = new Property(3, String.class, "term_priority", false, "TERM_PRIORITY");
        public final static Property Term_code = new Property(4, String.class, "term_code", false, "TERM_CODE");
        public final static Property Dict_code = new Property(5, String.class, "dict_code", false, "DICT_CODE");
    };


    public TermDao(DaoConfig config) {
        super(config);
    }
    
    public TermDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TERM\" (" + //
                "\"TERM_VERSION\" TEXT," + // 0: term_version
                "\"TERM_PINYIN\" TEXT," + // 1: term_pinyin
                "\"TERM_NAME\" TEXT," + // 2: term_name
                "\"TERM_PRIORITY\" TEXT," + // 3: term_priority
                "\"TERM_CODE\" TEXT," + // 4: term_code
                "\"DICT_CODE\" TEXT);"); // 5: dict_code
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TERM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Term entity) {
        stmt.clearBindings();
 
        String term_version = entity.getTerm_version();
        if (term_version != null) {
            stmt.bindString(1, term_version);
        }
 
        String term_pinyin = entity.getTerm_pinyin();
        if (term_pinyin != null) {
            stmt.bindString(2, term_pinyin);
        }
 
        String term_name = entity.getTerm_name();
        if (term_name != null) {
            stmt.bindString(3, term_name);
        }
 
        String term_priority = entity.getTerm_priority();
        if (term_priority != null) {
            stmt.bindString(4, term_priority);
        }
 
        String term_code = entity.getTerm_code();
        if (term_code != null) {
            stmt.bindString(5, term_code);
        }
 
        String dict_code = entity.getDict_code();
        if (dict_code != null) {
            stmt.bindString(6, dict_code);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Term entity) {
        stmt.clearBindings();
 
        String term_version = entity.getTerm_version();
        if (term_version != null) {
            stmt.bindString(1, term_version);
        }
 
        String term_pinyin = entity.getTerm_pinyin();
        if (term_pinyin != null) {
            stmt.bindString(2, term_pinyin);
        }
 
        String term_name = entity.getTerm_name();
        if (term_name != null) {
            stmt.bindString(3, term_name);
        }
 
        String term_priority = entity.getTerm_priority();
        if (term_priority != null) {
            stmt.bindString(4, term_priority);
        }
 
        String term_code = entity.getTerm_code();
        if (term_code != null) {
            stmt.bindString(5, term_code);
        }
 
        String dict_code = entity.getDict_code();
        if (dict_code != null) {
            stmt.bindString(6, dict_code);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Term readEntity(Cursor cursor, int offset) {
        Term entity = new Term( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // term_version
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // term_pinyin
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // term_name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // term_priority
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // term_code
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // dict_code
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Term entity, int offset) {
        entity.setTerm_version(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTerm_pinyin(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTerm_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTerm_priority(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setTerm_code(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDict_code(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Term entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Term entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}