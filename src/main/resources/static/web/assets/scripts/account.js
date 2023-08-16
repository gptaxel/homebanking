const { createApp } = Vue;


const options = createApp({
    data() {
        return {
            client: {},
            transactions: [],
            account: [],
            searchParam: ""
        }
    },

    created() {
        this.loadClient()
        this.loadTransactions()
    },
    
    methods: {
        loadClient() {

            axios.get("http://localhost:8080/api/clients/2")
                .then(data => {
                    this.client = data.data
                    console.log(this.client)
                })
                .catch(error => console.log("ERROR"))
        },

        loadTransactions() {
            let accountSelect = location.search;
            console.log(location.search);
            let accountIdSearch = new URLSearchParams(accountSelect)
            console.log(accountIdSearch);
            let accountId = accountIdSearch.get('id')
            console.log(accountId);

            axios.get("http://localhost:8080/api/accounts/" + accountId)
                .then(response => {
                    this.account = response.data
                    this.transactions = [...response.data.transactions];
                    console.log(this.transactions.sort((a, b) => b.id - a.id));
                    console.log(typeof this.transactions);
                })
                .catch(error => console.log("ERROR"))
        }
    }
})

options.mount("#app")