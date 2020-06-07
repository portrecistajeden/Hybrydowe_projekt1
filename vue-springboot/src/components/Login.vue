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
//import axios from 'axios';
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
   methods:{
    async Login(){
          try{
            this.$store.dispatch('login',{
              login:this.user.username,
              password:this.user.password
            })

             this.$store.dispatch('getUserID',{
              login:this.user.username,
              password:this.user.password
            })

              this.$store.state.LoggedUser.login=this.user.username
               this.$router.push("/")
               
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