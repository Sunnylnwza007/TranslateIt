package buu.informatics.s59160090.translateit.database


import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import androidx.fragment.app.FragmentActivity

/**
 * Created by Eyehunt Team on 07/06/18.
 */
class DatabaseHandler(context: FragmentActivity?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSIOM) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME " +
                "($ID Integer PRIMARY KEY, $NAME TEXT, $SCORE Integer)"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Called when the database needs to be upgraded
    }

    //Inserting (Creating) data
    fun addUser(user: Users): Boolean {
        //Create and/or open a database that will be used for reading and writing.
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME, user.name)
        values.put(SCORE, user.score)
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }

    //get all users
    fun getAllUsers(): String {
        var allUser: String = "";
        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM $TABLE_NAME ORDER BY $SCORE DESC LIMIT 8"
        val cursor = db.rawQuery(selectALLQuery, null)
        var num = 1
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    var id = num
                    var name = cursor.getString(cursor.getColumnIndex(NAME))

                    allUser = "$allUser\n $id $name"
                    num++
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return allUser
    }

    fun getAllScore(): String {
        var allScore: String = "";
        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM $TABLE_NAME ORDER BY $SCORE DESC LIMIT 8"
        val cursor = db.rawQuery(selectALLQuery, null)
        var num = 1
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    var score = cursor.getString(cursor.getColumnIndex(SCORE))

                    allScore = "$allScore\n $score"
                    num++
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return allScore
    }

    companion object {
        private val DB_NAME = "UsersDB"
        private val DB_VERSIOM = 1;
        private val TABLE_NAME = "users"
        private val ID = "id"
        private val NAME = "Name"
        private val SCORE = "Score"
    }
}