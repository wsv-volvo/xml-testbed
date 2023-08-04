package com.volvocars.xmltestbed.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/*
 * Document root node
 * Basic element of string type
 * Nested object
 * List of objects
 */
@Root(name = "test")
data class TestDto
@JvmOverloads constructor(
    @field:Element var title: String = "",
    @field:Element var detail: TestDetailDto? = null,
    @field:ElementList(entry = "item", required = false) var items: ArrayList<TestItemDto>? = null
)
