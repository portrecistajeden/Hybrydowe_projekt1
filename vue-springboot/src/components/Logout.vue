<template>
    <div>
        <div>Czy na pewno wylogować?</div> 
         <br> <input type="submit" @click="Logout"  value="Wyloguj">
        </div>
 
</template>

<script>
export default {
    name:"Logout",
    mounted(){
      if(!localStorage.getItem('token')){
          this.$router.push("/login")
        }
        
    },
     methods:{
         Logout(){
             this.$store.dispatch('logout')
             this.$store.state.LoggedUser.login=''
            this.$router.push("/");
             
         }
        
   }
}
</script>