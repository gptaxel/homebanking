const { createApp } = Vue;

const options = createApp({
    data() {
        return {
            client: [],
            accounts: [],
            loans: []
        }
    },
    
    created() {
        this.loadData()
    },

    methods: {

        loadData() {
            axios.get("http://localhost:8080/api/clients/2")
                .then(data => {
                    this.client = data.data
                    console.log(this.client);
                    this.accounts = data.data.accounts
                    console.log(this.accounts);
                    this.loans = data.data.loans
                    console.log(this.loans);
                })
                .catch(error => console.log("ERROR"))
        },
    }
})

options.mount("#app")