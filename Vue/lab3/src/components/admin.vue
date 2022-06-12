<template>
    <div>
        <h1>Admins</h1>
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
                <tr v-for="admin, index in admins" :key="admin.name">
                    <td>{{ index }}</td>
                    <td>{{ admin.name }}</td>
                    <td>{{ admin.age }}</td>
                    <td>{{ admin.address }}</td>
                    <td><button class="btn btn-danger" @click="$emit('deletingAdmin', index)">Delete</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    name: 'adminApp',
    props: ['admins'],
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