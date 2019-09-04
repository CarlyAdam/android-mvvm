package com.carlyadam.kotlin

import androidx.lifecycle.MutableLiveData
import com.carlyadam.kotlin.data.db.Person
import com.carlyadam.kotlin.data.db.PersonDao
import com.carlyadam.kotlin.viewmodel.PersonViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


//following given-when-then pattern

@RunWith(JUnit4::class)
class FullTest {

    @Test
    fun `testing dao`()  {

        val fakeResponse = MutableLiveData<List<Person>>()


        //given
        val personDao = mockk<PersonDao>()
        every { personDao.getPersons() } returns fakeResponse

        // when
        val result = personDao.getPersons()

        // then
        verify { personDao.getPersons() }
        assertEquals(fakeResponse, result)
    }

    @Test
    fun `testing repository`() {

        val fakeResponse = MutableLiveData<List<Person>>()


        //given
        val personRepository = mockk<PersonDao>()
        every { personRepository.getPersons() } returns fakeResponse

        // when
        val result = personRepository.getPersons()

        // then
        verify { personRepository.getPersons() }
        assertEquals(fakeResponse, result)
    }

    @Test
    fun `testing viewModel`() = runBlocking {

        val fakeResponse = MutableLiveData<List<Person>>()

        //given
        val personViewModel = mockk<PersonViewModel>()
        coEvery { personViewModel.getPerson() } returns fakeResponse

        // when
        val result = personViewModel.getPerson()

        //then
        assertEquals(fakeResponse, result)
        assertNotNull(result)
    }


}
