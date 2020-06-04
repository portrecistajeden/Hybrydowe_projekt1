<template>

<div >
<h2>Log in</h2>

<form >
   
  <div class="form-group">
    <input type="text" v-model="user.username" placeholder="login" required>
    <br> <input type="password" v-model="user.password" placeholder="password" required >
    <br><br> <input type="submit" @click="Login"  value="Log in">
  </div>
  <p v-if="errors.length">
    <a style="color:red" v-for="error in errors" :key="error">{{ error }}</a>
  </p>
</form>

</div>

</template>

<script>
import axios from 'axios';

export default {
  name: "Login",
  data() {
    return {
      //usersList: [],
      user:{
        username:"",
        password:""
      },
      errors:[]
    };
  },
 
 async mounted(){
          //  try{
          //   await axios.get('http://localhost:8080/users').then(users => this.usersList=users.data)
             
          //  }
          //  catch(e){
          //    console.error(e);
          //  }
   },
   methods:{
    async Login(){
          try{
             await axios.post('http://localhost:8080/login',{
              login:this.user.username,
              password:this.user.password
              
            });
            this.$router.push("/");
           }
           catch(e){
           this.errors=[];
           this.errors.push("Invalid login or password")
           }

   }

   }
};
</script>

<style>
</style>