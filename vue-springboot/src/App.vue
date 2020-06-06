<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <div style="padding:5px" class="navbar-brand"> <router-link to="/" tag="span" style="color:white">API</router-link></div>
         
      <div class="navbar-nav mr-auto">
        <div style="padding:5px"> <router-link to="/books" tag="span" style="color:white">Books</router-link></div>
        
         <div style="padding:5px"><router-link to="/users" tag="span" style="color:white">Users</router-link></div>  
         
      
        
      </div>
     
      <div>
        <a v-if="$store.state.LoggedUser.login" style="color:white; padding:15px" >Hello, {{$store.state.LoggedUser.login}}</a>
 <router-link v-if="!$store.state.LoggedUser.login" to="/login" tag="span" style="color:white">Log in</router-link>
    <router-link v-if="$store.state.LoggedUser.login" to="/logout" tag="span" style="color:white">Log out</router-link>    
          <!-- <a href="/login" class="nav-link">Login</a> -->
       
</div>
    </nav>

    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>