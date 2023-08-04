package com.volvocars.xmltestbed.model

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Path
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/*
 * Document root node
 * Basic element of string type
 * Nested object
 * List of objects
 */
@Xml(name = "test")
data class TestDto(
    @PropertyElement val title: String = "",
    @Element(name = "detail") val detail: TestDetailDto? = null,
    @Path("items") @Element(name = "item") val items: List<TestItemDto>? = null
)
