<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <a href="#" class="navbar-brand">API</a>
      <div class="navbar-nav mr-auto">
        <div style="padding:5px"> <router-link to="/" tag="span" style="color:white">Books</router-link></div>
        
         <div style="padding:5px"><router-link to="/register" tag="span" style="color:white">Add new user</router-link></div>  
         
      
        
      </div>
     
      <div>
 <router-link to="/login" tag="span" style="color:white">Log in</router-link>
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