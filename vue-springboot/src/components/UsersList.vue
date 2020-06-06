<template>
  <div class="list row">
    <div class="col-md-8">
   <div class="form-group col-md-8">
    <input @keyup.enter="SearchUser" class="search" v-model="searchValue" placeholder="wyszukiwanie..">
    </div>
      <div class="input-group mb-3">
      </div>
    </div>
    <div><input type="submit" @click="addUser()" value="Dodaj użytkownika"></div>
   
   
    <table>
      <tr>
        <th>
          Nazwa użytkownika
        </th>
        <th></th>
      </tr>
      <tr  v-for="user in users" :key="user.idUser">
        <th>
         {{user.login}}
        </th>
         
         
        <th> <input type="submit" @click="deleteUser(user.idUser)" value="Usuń"></th>
      </tr>
    </table>
   
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
export default {
  name: "UsersList",
  data() {
    return {
      searchValue:'',
      valueSelect:'Tytuł'
    };
  },
  computed:{
      ...mapGetters({
          users:'users',
          ref:'ref'
        }
      )
  },
  watch:{
    ref(){
       this.$store.dispatch('getUsers')
    }
  },
 async mounted(){
           try{
          // await axios.get('http://localhost:8080/users').then(users => this.library=users.data)
            this.$store.dispatch('getUsers')
           }
           catch(e){
             console.error(e);
           }
   },
   methods:{
     addUser(){
        this.$router.push("/register");
    
      },
    async deleteUser(idUser){
      try{
           this.$store.dispatch('deleteUser',idUser)
           
            console.log(idUser);
            // window.location.reload();
           }
           catch(e){
             console.error(e);
           }
      },


      async SearchUser(){
         try{
           if(this.searchValue==""){
             this.$store.dispatch('getUsers')
           }
           else {
             console.log("halo")
               this.$store.dispatch('searchUser',this.searchValue)
               }
          
           }
           catch(e){
             console.error(e);
           }
      }

      
   }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
.search{
  display: flex;
  flex-direction: column;
  width: 250px;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
}
</style>