<template>
  <div>
    <button class="btn btn-sm btn-primary col-2 m-1" @click="showFormMethod">Form</button>
    <button class="btn btn-sm btn-info col-2 m-1" @click="showStudentsMethod">Students</button>
    <button class="btn btn-sm btn-info col-2 m-1" @click="showAdminsMethod">Admins</button>
    <formApp v-if="showForm" @addingNewAdmin="addNewAdmin" @addingNewStudent="addNewStudent" />
    <!-- <adminApp :admins="users.filter((arr) => arr.role == 'admin')" v-if="showAdmins" @deletingUser="deleteUser" /> -->
    <!-- <studentApp :students="users.filter((arr) => arr.role == 'student')" v-if="showStudents" @deletingUser="deleteUser" /> -->
    <adminApp :admins="admins" v-if="showAdmins" @deletingAdmin="deleteAdmin" />
    <studentApp :students="students" v-if="showStudents" @deletingStudent="deleteStudent" />
  </div>
</template>

<script>
import formApp from './components/form.vue'
import adminApp from './components/admin.vue'
import studentApp from './components/student.vue'
import { ref } from 'vue'

export default {
  name: 'App',
  components: {
    formApp,
    adminApp,
    studentApp
  },
  setup() {
    const showForm = ref(true)
    const showAdmins = ref(false)
    const showStudents = ref(false)
    const admins = ref([
      {
        name: 'Dina',
        age: 23,
        address: "Alexandria"
      }
    ])
    const students = ref([
      {
        name: 'Sarah',
        age: 22,
        address: "cairo"
      }
    ])
    function showFormMethod() {
      showForm.value = true
      showAdmins.value = false
      showStudents.value = false
    }
    function showStudentsMethod() {
      showForm.value = false
      showAdmins.value = false
      showStudents.value = true
    }
    function showAdminsMethod() {
      showForm.value = false
      showAdmins.value = true
      showStudents.value = false
    }
    function addNewAdmin(newAdmin) {
      admins.value.push(newAdmin);
    }
    function addNewStudent(newStudent) {
      students.value.push(newStudent);
    }
    function deleteStudent(index) {
      students.value.splice(index, 1);
    }
    function deleteAdmin(index) {
      admins.value.splice(index, 1);
    }
    return {
      showForm,
      showAdmins,
      showStudents,
      admins,
      students,
      showFormMethod,
      showStudentsMethod,
      showAdminsMethod,
      addNewAdmin,
      addNewStudent,
      deleteStudent,
      deleteAdmin
    }
  },
  data() {
    return {
    }
  },
  methods: {
  }
}
</script>

<style>
* {
  background-color: black;
  color: white;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  /* margin-top: 60px; */
}

@import "~bootstrap/dist/css/bootstrap.css";
</style>
