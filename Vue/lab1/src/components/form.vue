<template>
    <div>
        <form @submit.prevent="addUser" ref="form">
            <div class="container col-8 row">
                <div class="input-group input-group-sm mb-3 offset-4 row">
                    <div class="col-12">
                        Name<input type="text" class="form-control form-control-sm" aria-label="Sizing example input"
                            aria-describedby="inputGroup-sizing-sm" id="name" v-model="newUser['name']" />
                    </div>
                </div>
                <div class="input-group input-group-sm mb-3 offset-4 row">
                    <div class="col-12">
                        Age<input type="number" class="form-control form-control-sm" aria-label="Sizing example input"
                            aria-describedby="inputGroup-sizing-sm" id="age" v-model="newUser['age']" />
                    </div>
                </div>
                <div class="input-group input-group-sm mb-3 offset-4 row">
                    <div class="col-12">
                        Address<input type="text" class="form-control form-control-sm" aria-label="Sizing example input"
                            aria-describedby="inputGroup-sizing-sm" id="address" v-model="newUser['address']" />
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
export default {
    name: 'formApp',
    components: {
    },
    data() {
        return {
            newUser: {
                name: ' ',
                age: 0,
                address: ' '
            },
            role: 'admin'
        }
    },
    methods: {
        addUser() {
            if (this.role == 'admin') {
                this.$emit("addingNewAdmin", this.newUser)
            } else {
                this.$emit("addingNewStudent", this.newUser)
            }
          
            this.newUser = {
                name: ' ',
                age: 0,
                address: ' '
            }
            this.role = 'admin'
        },
    }
}
</script>

<style scoped>
</style>