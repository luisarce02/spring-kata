package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.repository.StudentRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

  @Test
  public void addStudent_shouldAddStudentCorrectly_Equals() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");

    when(repo.save(student)).thenReturn(student);
    Student studentExpected = studentServiceImpl.addStudent(student);

    assertNotNull(studentExpected);
    assertEquals(student, studentExpected);
  }

  @Test
  public void addStudent_shouldAddSomeStudentsCorrectly_Equals() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");
    Student studentTwo = new Student(5L, "carlos", "dario");
    Student studentThree = new Student(6L, "javier", "montanio");

    when(repo.save(student)).thenReturn(student);
    when(repo.save(studentTwo)).thenReturn(studentTwo);
    when(repo.save(studentThree)).thenReturn(studentThree);
    Student studentExpected = studentServiceImpl.addStudent(student);
    Student studentExpectedTwo = studentServiceImpl.addStudent(studentTwo);
    Student studentExpectedThree = studentServiceImpl.addStudent(studentThree);

    assertNotNull(studentExpected);
    assertNotNull(studentExpectedTwo);
    assertNotNull(studentExpectedThree);
    assertEquals(student, studentExpected);
    assertEquals(studentTwo, studentExpectedTwo);
    assertEquals(studentThree, studentExpectedThree);
  }

  @Test
  public void findAll_shouldReturnStudent_sameName() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");
    List<Student> studentList = new ArrayList<>();
    studentList.add(student);

    when(repo.save(student)).thenReturn(student);
    when(repo.findAll()).thenReturn(studentList);


    List<Student> listExpected = studentServiceImpl.findAll();

    assertEquals(studentList.get(0).getName(), listExpected.get(0).getName());
  }

  @Test
  public void findAll_shouldReturnAllStudents_sameSize() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");
    Student studentTwo = new Student(5L, "gabriel", "gomez");
    Student studentThree = new Student(6L, "maria", "salva");

    List<Student> studentList = new ArrayList<>();
    studentList.add(student);
    studentList.add(studentTwo);
    studentList.add(studentThree);

    when(repo.save(student)).thenReturn(student);
    when(repo.save(studentTwo)).thenReturn(studentTwo);
    when(repo.save(studentThree)).thenReturn(studentThree);
    when(repo.findAll()).thenReturn(studentList);

    List<Student> listExpected = studentServiceImpl.findAll();

    assertEquals(studentList.size(), listExpected.size());
  }

  @Test
  public void edit_shouldEditStudentCorrectly_Equals() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");
    Student studentEdit = new Student(4L, "ana","Panozo");

    when(repo.save(student)).thenReturn(student);
    when(repo.edit(student)).thenReturn(studentEdit);
    Student studentExpected = studentServiceImpl.edit(student);

    assertNotNull(studentExpected);
    assertEquals(studentEdit, studentExpected);
  }

  @Test
  public void delete_shouldDeleteStudentCorrectly_FindAllEmpty() {
    StudentRepo repo = mock(StudentRepo.class);
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl(repo);
    Student student = new Student(4L, "ana", "perez");

    when(repo.save(student)).thenReturn(student);
    when(repo.delete(student)).thenReturn(true);
    Boolean deleteExpected = studentServiceImpl.delete(student);

    assertEquals(true, deleteExpected);
  }
}