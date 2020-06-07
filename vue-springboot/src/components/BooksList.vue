<template>
  <div class="list row">
    <div class="col-md-8">
   <div class="form-group col-md-8">
    <input @keyup.enter="SearchingBook" class="search" v-model="searchValue" placeholder="wyszukiwanie..">
    <select class="form-control" id="exampleFormControlSelect1" v-model="valueSelect" >
      <option >Tytuł</option>
      <option>Autorzy</option>
      <option>Rok wydania</option>
    </select>
    </div>
      <div class="input-group mb-3">
      </div>
    </div>
    <div><input type="submit" @click="addBook()" value="Dodaj książkę"></div>
   
   
    <table>
      <tr>
        <th>
          Tytuł
        </th>
         <th>
          Autorzy
        </th>
         <th>
          Rok wydania
        </th>
        <th></th>
      </tr>
      <tr  v-for="book in library" :key="book.idBook">
        <th>
         {{book.title}}
        </th>
         <th>
         {{book.authors}}
        </th>
         <th>
          {{book.yearofpublishment}}
        </th>
        <th> <input type="submit" @click="deleteBook(book.idBook)" value="Usuń"></th>
      </tr>
    </table>
   
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
export default {
  name: "BooksList",
  data() {
    return {
      searchValue:'',
      valueSelect:'Tytuł'
    };
  },
  computed:{
      ...mapGetters({
          library:'library',
          refresh:'refresh'
        }
      )
  },
  watch:{
    refresh(){
       this.$store.dispatch('getBooks')
    }
  },
 async mounted(){
   if(!localStorage.getItem('token')){
     this.$router.push("/login")
   }
   else if(localStorage.getItem('idUser')=="1"){
 try{
        
             this.$store.dispatch('getBooks')
           }
           catch(e){
             
             console.error(e);
           }
   }
   else{
     this.$router.push("/")
   }
   
          
   },
   methods:{
     addBook(){
        this.$router.push("/addBook");
     },
      async deleteBook(idBook){
      try{
           this.$store.dispatch('deleteBook',idBook)
           
            console.log(idBook);
            // window.location.reload();
           }
           catch(e){
             console.error(e);
           }
      },

      async SearchingBook(){
         try{
           if(this.searchValue==""){
             this.$store.dispatch('getBooks')
           }
           else if(this.valueSelect==='Tytuł'){
             console.log("halo")
               this.$store.dispatch('searchTitle',this.searchValue)
               }
           else if(this.valueSelect==='Autorzy'){
               this.$store.dispatch('searchAuthors',this.searchValue)
           }
          else if(this.valueSelect==='Rok wydania'){
             this.$store.dispatch('searchYear',this.searchValue)
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