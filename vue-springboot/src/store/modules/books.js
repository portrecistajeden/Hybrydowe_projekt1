import axios from 'axios';

const state={
    library:[],
    refresh:0,
    book:{}
}

const getters={
    library: state=>{
        return state.library
    },

    refresh:state=>{
        return state.refresh
    },
    book:state=>{
        return state.book
    }
    
}

//wywołuje axios'owe puknięcie
const actions={
    getBooks({commit}){
        const auth={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
         axios.get('http://localhost:8080/books',auth)
         .then(result=>commit('LIBRARY',result.data))
           
    },

    deleteBook({commit},idBook){
        const auth2={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
         axios.delete('http://localhost:8080/books/delete/'+idBook,auth2)
         .then(()=>commit('REFRESH'))
    },

    addBook({commit},book){
        const auth3={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
         axios.post('http://localhost:8080/books/create',book,auth3)
         .then(()=>commit('REFRESH'))
    },
    searchTitle({commit},searchValue){
        const auth4={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
         axios.get('http://localhost:8080/books/title/'+searchValue,auth4)
        .then(result=>commit('LIBRARY',result.data))
    },
    searchAuthors({commit},searchValue){
        const auth5={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
         axios.get('http://localhost:8080/books/authors/'+searchValue,auth5)
        .then(result=>commit('LIBRARY',result.data))
    },
    searchYear({commit},searchValue){
        const auth6={
            headers:{Authorization:"Bearer "+localStorage.getItem('token'),auth6}
        }
         axios.get('http://localhost:8080/books/year/'+searchValue,auth6)
        .then(result=>commit('LIBRARY',result.data))
    }
}

//modyfikacje stanu
const mutations={
    LIBRARY(state,library){
        state.library=library
    },
    REFRESH(state){
        state.refresh=++state.refresh
    }
}


//export
export default{
    state,
    getters,
    actions,
    mutations
}