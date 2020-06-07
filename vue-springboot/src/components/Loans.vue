<template>
  <div class="list row">
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
      <tr  v-for="book in notBorrowedBooks" :key="book.idBook">
        <th>
         {{book.title}}
        </th>
         <th>
         {{book.authors}}
        </th>
         <th>
          {{book.yearofpublishment}}
        </th>
        <th> <input type="submit" @click="loans(book.idBook)" value="Wypożycz"></th>
      </tr>
    </table>
   
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
//import axios from 'axios'
export default {
  name: "Loans",
  data() {
    return {
      searchValue:'',
      valueSelect:'Tytuł'
    };
  },
  computed:{
      ...mapGetters({
          notBorrowedBooks:'notBorrowedBooks',
          refr:'refr'
        }
      )
  },
  watch:{
    refr(){
       this.$store.dispatch('getNotBorrowedBooks')
    }
  },
 async mounted(){
           try{
         //   await axios.get('http://localhost:8080/books').then(books => this.library=books.data)
             this.$store.dispatch('getNotBorrowedBooks')
           }
           catch(e){
             
             console.error(e);
           }
   },
   methods:{
       loans(idBook){
           try{
         //   await axios.get('http://localhost:8080/books').then(books => this.library=books.data)
             this.$store.dispatch('loansBook',idBook)
           }
           catch(e){
             console.log("tu")
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