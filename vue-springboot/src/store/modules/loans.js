import axios from 'axios';

const state={
    notBorrowedBooks:[],
    borrowBooks:[],
    refr:0,
    refrr:0
}

const getters={
    notBorrowedBooks: state=>{
        return state.notBorrowedBooks
    },
    borrowBooks: state=>{
        return state.borrowBooks
    },
    refr:state=>{
        return state.refr
    },
    refrr:state=>{
        return state.refrr
    }
}

//wywołuje axios'owe puknięcie
const actions={
    getNotBorrowedBooks({commit}){
        const auth={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
         axios.get('http://localhost:8080/books/available',auth)
         .then(result=>commit('NOTBORROWEDBOOKS',result.data))
           
    },
    getBorrowedBooks({commit}){
        const auth3={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
        const idUserr=localStorage.getItem('idUser');
         axios.get('http://localhost:8080/loans/'+idUserr,auth3)
         .then(result=>commit('BORROWBOOKS',result.data))
           
    },
    loansBook({commit},idBook){
        const auth2={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
        const idUser=localStorage.getItem('idUser');
         axios.post('http://localhost:8080/books/rent/'+idBook+"/"+idUser,auth2)
         .then(()=>commit('REFR'))
    },
    borrowBook({commit},idBook){
        const auth4={
            headers:{Authorization:"Bearer "+localStorage.getItem('token')}
        }
        const idUserrr=localStorage.getItem('idUser');
         axios.post('http://localhost:8080/books/return/'+idBook+"/"+idUserrr,auth4)
         .then(()=>commit('REFR'))
    }
    
}

//modyfikacje stanu
const mutations={
    NOTBORROWEDBOOKS(state,notBorrowedBooks){
        state.notBorrowedBooks=notBorrowedBooks
    },
    BORROWBOOKS(state,borrowBooks){
        state.borrowBooks=borrowBooks
    },
    REFR(state){
        state.refr=++state.refr
    },
    REFRR(state){
        state.refrr=++state.refrr
    }
}


//export
export default{
    state,
    getters,
    actions,
    mutations
}