<template>
    <div>
        <form @submit.prevent="addUser" ref="form">
            <div class="container col-8 row">
                <div class="input-group input-group-sm mb-2 offset-4 row">
                    <div class="col-12">
                        Name<input ref="nameInput" type="text" class="form-control form-control-sm"
                            aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" id="name"
                            v-model="name" />
                    </div>
                </div>
                <div class="input-group input-group-sm mb-3 offset-4 row">
                    <div class="col-12">
                        Age<input type="number" class="form-control form-control-sm" aria-label="Sizing example input"
                            aria-describedby="inputGroup-sizing-sm" id="age" v-model="age" />
                    </div>
                </div>
                <div class="input-group input-group-sm mb-3 offset-4 row">
                    <div class="col-12">
                        Address<input type="text" class="form-control form-control-sm" aria-label="Sizing example input"
                            aria-describedby="inputGroup-sizing-sm" id="address" v-model="address" />
                    </div>
                </div>
            </div>
            <div class="offset-5 col-2">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role" value="admin" v-model="role" checked />
                    <label class="form-check-label" for="Admin"> Admin </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role" value="student" v-model="role" />
                    <label class="form-check-label" for="Student"> Student </label>
                </div>
            </div>
            <input type="submit" class="btn btn-sm btn-success m-1 mt-4 col-4" value="Add">
        </form>
    </div>
</template>

<script>
import { ref, onMounted } from 'vue'
export default {
    name: 'formApp',
    components: {
    },
    setup(props, context) {
        const name = ref(' ')
        const age = ref(0)
        const address = ref(' ')
        const role = ref('admin')
        const nameInput = ref(null)
        onMounted(() => {
            nameInput.value.focus()
        })
        function addUser() {
            if (role.value == 'admin') {
                context.emit('addingNewAdmin', { 'name': name.value, 'age': age.value, 'address': address.value })
            } else {
                context.emit('addingNewStudent', { 'name': name.value, 'age': age.value, 'address': address.value })
            }
            name.value = ' '
            age.value = 0
            address.value = ' '
            role.value = 'admin'
        }
        return {
            name,
            age,
            address,
            role,
            nameInput,
            addUser
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

<style scoped>
</style>