package com.volvocars.xmltestbed

import com.volvocars.xmltestbed.model.TestDetailDto
import com.volvocars.xmltestbed.model.TestDto
import com.volvocars.xmltestbed.model.TestEnum
import com.volvocars.xmltestbed.model.TestItemDto
import org.junit.Assert.assertEquals
import org.junit.Test
import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.stream.Format
import java.io.StringWriter

class Tests {
    @Test
    fun objectToXml() {
        val obj = TestDto(
            title = "Testing",
            detail = TestDetailDto(
                id = "1",
                bool = true,
                intNumber = 47,
                floatNumber = 3.14f,
                enumValue = TestEnum.ALPHA
            ),
            items = listOf(
                TestItemDto("one", 1),
                TestItemDto("two", 2)
            )
        )

        val expected = "<test>" +
                "<title>Testing</title>" +
                "<detail id=\"1\">" +
                "<bool>true</bool>" +
                "<intNumber>47</intNumber>" +
                "<floatNumber>3.14</floatNumber>" +
                "<enumValue>ALPHA</enumValue>" +
                "</detail>" +
                "<items>" +
                "<item id=\"one\" value=\"1\"/>" +
                "<item id=\"two\" value=\"2\"/>" +
                "</items>" +
                "</test>"

        val actual = serialize(obj)
        assertEquals(expected, actual)
    }

    private fun <T> serialize(obj: T): String = with(StringWriter()) {
        Persister(Format(0)).write(obj, this)
        this.toString()
    }
}
