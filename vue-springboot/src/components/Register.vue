<template>

<div >
<h2>Add new user</h2>

<form >
   
  <div class="form-group">
    <input type="text" v-model="user.username" placeholder="login" required>
    <br> <input type="password" v-model="user.password" placeholder="password" required >
    <br><input type="checkbox" v-model="checkAdmin" value="Admin">
    <label style="padding :5px">Admin?</label>
    <br> <input type="submit" @click="Register"  value="Create">
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
  name: "Register",
  data() {
    return {
      //usersList: [],
      user:{
        username:"",
        password:""
      },
      errors:[],
      checkAdmin:false
    };
  },
 
 async mounted(){
   },
   methods:{
    async Register(){
         if(this.checkAdmin==false){
             console.log(this.checkAdmin);
              try{
             await axios.post('http://localhost:8080/register',{
              login:this.user.username,
              password:this.user.password
              
            });
            this.$router.push("/users");
            console.log("succes");
           }
           catch(e){
           this.errors=[];
           this.errors.push("Invalid login or password")
           }

          }
          else{
               console.log(this.checkAdmin);
              try{
             await axios.post('http://localhost:8080/registerAdmin',{
              login:this.user.username,
              password:this.user.password
              
            });
            //this.$router.push("/");
            console.log("succes");
           }
           catch(e){
           this.errors=[];
           this.errors.push("Invalid login or password")
           } 
          }
          
   }

   }
};
</script>

<style>
</style>