package domain.extensions

import com.kmpktor.VisitorDto
import domain.model.Visitor
import kotlinx.datetime.Instant

fun VisitorDto.toVisitor(): Visitor {
    return Visitor(id = this.id, name = this.name, timeOfVisit = Instant.parse(this.timeOfVisit), countryId = this.countryId)
}

fun Visitor.toDto(): VisitorDto {
    return VisitorDto(id = this.id, name = this.name, timeOfVisit = this.timeOfVisit.toString(), countryId = this.countryId)
}