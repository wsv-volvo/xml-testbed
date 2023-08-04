package com.volvocars.xmltestbed

import com.volvocars.xmltestbed.model.TestDetailDto
import com.volvocars.xmltestbed.model.TestDto
import com.volvocars.xmltestbed.model.TestEnum
import com.volvocars.xmltestbed.model.TestItemDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import nl.adaptivity.xmlutil.serialization.XML
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class Tests {
    @Test
    fun objectToXml_fullObject() {
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
                "<int>47</int>" +
                "<float>3.14</float>" +
                "<enum>ALPHA</enum>" +
                "</detail>" +
                "<items>" +
                "<item id=\"one\" value=\"1\" />" +
                "<item id=\"two\" value=\"2\" />" +
                "</items>" +
                "</test>"

        val actual = serialize(obj)
        assertEquals(expected, actual)
    }

    @Test
    fun objectToXml_partialObject() {
        val obj = TestDto(
            title = "Partial",
            detail = TestDetailDto(
                id = "9",
                enumValue = TestEnum.GAMMA
            )
        )

        val expected = "<test>" +
                "<title>Partial</title>" +
                "<detail id=\"9\">" +
                "<enum>GAMMA</enum>" +
                "</detail>" +
                "</test>"

        val actual = serialize(obj)
        assertEquals(expected, actual)
    }

    @Test
    fun xmlToObject_fullObject() {
        val source = "<test>" +
                "<title>More testing</title>" +
                "<detail id=\"2\">" +
                "<bool>true</bool>" +
                "<int>74</int>" +
                "<float>6.28</float>" +
                "<enum>GAMMA</enum>" +
                "</detail>" +
                "<items>" +
                "<item id=\"three\" value=\"3\"/>" +
                "<item id=\"four\" value=\"4\"/>" +
                "</items>" +
                "</test>"

        val actual = deserialize<TestDto>(source)
        with(actual) {
            assertEquals("More testing", title)
            with(detail!!) {
                assertEquals("2", id)
                assertEquals(true, bool)
                assertEquals(74, intNumber)
                assertEquals(6.28f, floatNumber)
                assertEquals(TestEnum.GAMMA, enumValue)
            }
            assertEquals(2, items!!.size)
            with(items!![0]) {
                assertEquals("three", id)
                assertEquals(3, value)
            }
            with(items!![1]) {
                assertEquals("four", id)
                assertEquals(4, value)
            }
        }
    }

    @Test
    fun xmlToObject_partialObject() {
        val source = "<test>" +
                "<title>Mostly empty</title>" +
                "<detail id=\"47\">" +
                "<bool>true</bool>" +
                "<int>1234</int>" +
                "</detail>" +
                "</test>"

        val actual = deserialize<TestDto>(source)
        with(actual) {
            assertEquals("Mostly empty", title)
            with(detail!!) {
                assertEquals("47", id)
                assertEquals(true, bool)
                assertEquals(1234, intNumber)
                assertNull(floatNumber)
                assertNull(enumValue)
                assertNull(items)
            }
        }
    }

    private inline fun <reified T> deserialize(source: String): T =
        XML().decodeFromString(source)

    private inline fun <reified T> serialize(obj: T): String =
        XML().encodeToString(obj)
}
