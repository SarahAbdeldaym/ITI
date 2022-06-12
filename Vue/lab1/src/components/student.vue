<template>
    <div>
        <h1>Students</h1>
        <table class="table table-bordered" style="color: white;">
            <thead align="center" style="color: green; font-weight: bold; font-size: larger;">
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody style="color: white;">
                <tr v-for="student, index in students" :key="student.name">
                    <td>{{ index }}</td>
                    <td>{{ student.name }}</td>
                    <td>{{ student.age }}</td>
                    <td>{{ student.address }}</td>
                    <td><button class="btn btn-danger" @click="$emit('deletingStudent', index)">Delete</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    name: 'studentApp',
    props: ['students'],
    components: {
    },
    data() {
        return {
        }
    },
    methods: {
    }
}
</script>

<style scoped>
</style>