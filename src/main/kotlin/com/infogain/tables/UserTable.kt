package com.infogain.tables

import org.jetbrains.exposed.sql.Table


object UsersTable : Table("users")
{
    val id =integer("id").autoIncrement()
    val name = varchar("name",255)
    val email = varchar ("email", 255)
    val password = varchar("password",255)
    val role = varchar("role",50)
    val createdAt = varchar("crated_at",255)
    val updatedAt = varchar("updated_at",255)
    override val primaryKey = PrimaryKey(id)

}