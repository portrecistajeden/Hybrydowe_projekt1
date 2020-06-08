<template>

<div >
<h2>Add new user</h2>

<form >
   
  <div class="form-group">
    <input type="text" v-model="user.username" placeholder="login" required>
    <br> <input type="text" v-model="user.password" placeholder="password">

    <input type="button" @click="GeneretePswd()" value="Generuj losowe hasło">

     <br><input type="submit" @click="Register()"  value="Stwórz">
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
 
   mounted(){
      if(!localStorage.getItem('token')){
          this.$router.push("/login")
        }
        else if(localStorage.getItem('idUser')!="1"){
           this.$router.push("/")
        }
        
    },
   methods:{
    async Register(){
       const auth={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}}
         if(this.checkAdmin==false){
             console.log(this.checkAdmin);
             
              try{
               
             await axios.post('https://hybrydkoweapi.azurewebsites.net/register',{
              login:this.user.username,
              password:this.user.password}, auth);
            this.$router.push("/users");
            console.log("succes");
           }
           catch(e){
           this.errors=[];
           this.errors.push("")
           }

          }
          
   },
   async GeneretePswd(){
      try{
         const auth={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}}
            await axios.post('https://hybrydkoweapi.azurewebsites.net/generatePassword', auth)
            .then(result=>{
                this.user.password=result.data;
                console.log(result.data)
            });
      }catch(e){
          console.log(e)
      }
   }

   }
};
</script>

<style>
</style>