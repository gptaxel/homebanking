const { createApp } = Vue;

const cards = createApp({
    data() {
        return {
            client: [],
            accounts: null,
            theme: 'ligth',
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
                })
                .catch(error => console.log("ERROR"))
        },
    }
})

cards.mount("#app")






























/* const { createApp } = Vue;

const options = {

    data() {
        return {
            clients: [],
            accounts: null
        }
    },

    created() {
        this.loadData();
    },

    methods: {
        loadData() {
            axios.get('http://localhost:8080/api/clients/2')
                .then(data => {
                    this.client = data.data
                    console.log(this.client);
                    this.accounts = data.data.accounts
                })
                .catch(error => {
                    console.log(error);
                });
        },

    },

}
const app = createApp(options);

app.mount('#app'); */