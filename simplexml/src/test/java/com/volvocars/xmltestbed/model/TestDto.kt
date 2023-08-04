package com.volvocars.xmltestbed.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root

@Root(name = "test")
data class TestDto
@JvmOverloads constructor(
    @field:Element var title: String = "",
    @field:Element var detail: TestDetailDto? = null,
    @field:Path("items") @field: ElementList(inline = true, entry = "item") var items: List<TestItemDto>? = null
)

