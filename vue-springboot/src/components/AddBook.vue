<template>
     <div>
      <h1>Nowa książka</h1>
      <form>
          <label>Tytuł</label>
         <p> <input
            v-model="book.bookTitle"
            type="text" required>
        </p>
         
          <label>Autorzy</label>
         <p> <input
            v-model="book.bookAuthors"
            type="text" required>
        </p>
        
          <label>Rok publikacji</label>
          <p> <input
            v-model="book.bookYearOfPublishment"
            type="number" required >
        </p>
        <input type="submit" @click="addBook" value="Add">
      </form>
    </div>
</template>
<script>
//import axios from 'axios'
export default {
    name:"AddBook",
    data(){
        return{
          book:{
          bookTitle:'',
          bookAuthors:'',
          bookYearOfPublishment:null,
      }
        }
        
        
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
      async addBook(){
      try{
       
         this.$store.dispatch('addBook',{
              authors:this.book.bookAuthors,
              title:this.book.bookTitle,
              yearofpublishment:this.book.bookYearOfPublishment
              
            })
            
             this.$router.push("/books");
         //   window.location.reload();
           }
           catch(e){
            // this.$router.push("/addBook");
            console.log("eee")
           }
      },
    }
}
</script>