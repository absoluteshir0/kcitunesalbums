package sn.nino.kcitunesalbums.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// DAO interface
// initialize SQLite queries
@Dao
interface SessionDao {
    @Insert
    fun addSession(session: Session)

    @Update
    fun updateSession(session: Session)

    @Query("SELECT * FROM user_session WHERE id = 0")
    fun getLastSession() : Session


}