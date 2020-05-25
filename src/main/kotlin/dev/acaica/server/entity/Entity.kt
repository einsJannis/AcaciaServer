package dev.acaica.server.entity

import dev.acaica.server.types.Position
import dev.acaica.server.types.Rotation
import java.util.*

interface Entity {
    val uniqueId: UUID
    var health: Int
    var position: Position
    var rotation: Rotation
}