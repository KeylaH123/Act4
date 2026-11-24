package com.example.mynotes.`data`

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class NoteDao_Impl(
  __db: RoomDatabase,
) : NoteDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfNote: EntityInsertAdapter<Note>

  private val __deleteAdapterOfNote: EntityDeleteOrUpdateAdapter<Note>

  private val __updateAdapterOfNote: EntityDeleteOrUpdateAdapter<Note>
  init {
    this.__db = __db
    this.__insertAdapterOfNote = object : EntityInsertAdapter<Note>() {
      protected override fun createQuery(): String = "INSERT OR ABORT INTO `notes` (`id`,`title`,`content`,`date`,`completed`,`imageUri`,`priority`) VALUES (nullif(?, 0),?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Note) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.title)
        statement.bindText(3, entity.content)
        statement.bindLong(4, entity.date)
        val _tmp: Int = if (entity.completed) 1 else 0
        statement.bindLong(5, _tmp.toLong())
        val _tmpImageUri: String? = entity.imageUri
        if (_tmpImageUri == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmpImageUri)
        }
        statement.bindText(7, entity.priority)
      }
    }
    this.__deleteAdapterOfNote = object : EntityDeleteOrUpdateAdapter<Note>() {
      protected override fun createQuery(): String = "DELETE FROM `notes` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Note) {
        statement.bindLong(1, entity.id)
      }
    }
    this.__updateAdapterOfNote = object : EntityDeleteOrUpdateAdapter<Note>() {
      protected override fun createQuery(): String = "UPDATE OR ABORT `notes` SET `id` = ?,`title` = ?,`content` = ?,`date` = ?,`completed` = ?,`imageUri` = ?,`priority` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Note) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.title)
        statement.bindText(3, entity.content)
        statement.bindLong(4, entity.date)
        val _tmp: Int = if (entity.completed) 1 else 0
        statement.bindLong(5, _tmp.toLong())
        val _tmpImageUri: String? = entity.imageUri
        if (_tmpImageUri == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmpImageUri)
        }
        statement.bindText(7, entity.priority)
        statement.bindLong(8, entity.id)
      }
    }
  }

  public override suspend fun insert(note: Note): Long = performSuspending(__db, false, true) { _connection ->
    val _result: Long = __insertAdapterOfNote.insertAndReturnId(_connection, note)
    _result
  }

  public override suspend fun delete(note: Note): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfNote.handle(_connection, note)
  }

  public override suspend fun update(note: Note): Unit = performSuspending(__db, false, true) { _connection ->
    __updateAdapterOfNote.handle(_connection, note)
  }

  public override fun observeAll(): Flow<List<Note>> {
    val _sql: String = "SELECT * FROM notes ORDER BY date DESC"
    return createFlow(__db, false, arrayOf("notes")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfContent: Int = getColumnIndexOrThrow(_stmt, "content")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _columnIndexOfCompleted: Int = getColumnIndexOrThrow(_stmt, "completed")
        val _columnIndexOfImageUri: Int = getColumnIndexOrThrow(_stmt, "imageUri")
        val _columnIndexOfPriority: Int = getColumnIndexOrThrow(_stmt, "priority")
        val _result: MutableList<Note> = mutableListOf()
        while (_stmt.step()) {
          val _item: Note
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpContent: String
          _tmpContent = _stmt.getText(_columnIndexOfContent)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          val _tmpCompleted: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfCompleted).toInt()
          _tmpCompleted = _tmp != 0
          val _tmpImageUri: String?
          if (_stmt.isNull(_columnIndexOfImageUri)) {
            _tmpImageUri = null
          } else {
            _tmpImageUri = _stmt.getText(_columnIndexOfImageUri)
          }
          val _tmpPriority: String
          _tmpPriority = _stmt.getText(_columnIndexOfPriority)
          _item = Note(_tmpId,_tmpTitle,_tmpContent,_tmpDate,_tmpCompleted,_tmpImageUri,_tmpPriority)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun findById(id: Long): Note? {
    val _sql: String = "SELECT * FROM notes WHERE id = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfContent: Int = getColumnIndexOrThrow(_stmt, "content")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _columnIndexOfCompleted: Int = getColumnIndexOrThrow(_stmt, "completed")
        val _columnIndexOfImageUri: Int = getColumnIndexOrThrow(_stmt, "imageUri")
        val _columnIndexOfPriority: Int = getColumnIndexOrThrow(_stmt, "priority")
        val _result: Note?
        if (_stmt.step()) {
          val _tmpId: Long
          _tmpId = _stmt.getLong(_columnIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpContent: String
          _tmpContent = _stmt.getText(_columnIndexOfContent)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          val _tmpCompleted: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfCompleted).toInt()
          _tmpCompleted = _tmp != 0
          val _tmpImageUri: String?
          if (_stmt.isNull(_columnIndexOfImageUri)) {
            _tmpImageUri = null
          } else {
            _tmpImageUri = _stmt.getText(_columnIndexOfImageUri)
          }
          val _tmpPriority: String
          _tmpPriority = _stmt.getText(_columnIndexOfPriority)
          _result = Note(_tmpId,_tmpTitle,_tmpContent,_tmpDate,_tmpCompleted,_tmpImageUri,_tmpPriority)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
