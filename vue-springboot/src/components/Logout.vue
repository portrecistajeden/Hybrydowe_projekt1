<template>
    <div></div>
</template>

<script>
export default {
    name:"Logout",

     mounted(){
          this.$store.state.LoggedUser.login=""
           this.$router.push("/");
   }
}
</script>