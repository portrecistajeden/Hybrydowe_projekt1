<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <div style="padding:5px" class="navbar-brand"> <router-link to="/" tag="span" style="color:white">API</router-link></div>
         
      <div class="navbar-nav mr-auto">
        <div style="padding:5px"> <router-link v-if="$store.state.LoggedUser.login==='admin'" to="/books" tag="span" style="color:white"> Książki  </router-link></div>
        
         <div style="padding:5px"><router-link v-if="$store.state.LoggedUser.login==='admin'" to="/users" tag="span" style="color:white">Użytkownicy</router-link></div>  
         
       <div style="padding:5px"><router-link v-if="($store.state.LoggedUser.login)" to="/loans" tag="span" style="color:white">Wypożyczalnia</router-link></div>  
       <div style="padding:5px"><router-link v-if="($store.state.LoggedUser.login)" to="/borrow" tag="span" style="color:white">Moje wypożyczenia</router-link></div>  
         
        
      </div>
     
      <div>
        <a v-if="$store.state.LoggedUser.login" style="color:white; padding:15px" >Hello, {{$store.state.LoggedUser.login}}</a>
 <router-link v-if="!$store.state.LoggedUser.login" to="/login" tag="span" style="color:white">Log in</router-link>
    <router-link v-if="$store.state.LoggedUser.login" to="/logout" tag="span" style="color:white">Log out</router-link>    
          <!-- <a href="/login" class="nav-link">Login</a> -->
      <!-- <span v-if="$store.state.isLoggedIn"> | <a>Logout</a></span>  -->
</div>
    </nav>
<!-- v-if="!$store.state.LoggedUser.login" -->
    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'app',
  data(){
    return {
      isLog:''
    };
  }

}
</script>