<template>
    <v-card outlined>
        <v-card-title>
            PlaceOrder
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <String label="ProductId" v-model="value.productId" :editMode="editMode"/>
            <String label="UserId" v-model="value.userId" :editMode="editMode"/>
            <Number label="Qty" v-model="value.qty" :editMode="editMode"/>
            <String label="ProductName" v-model="value.productName" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="placeOrder"
            >
                PlaceOrder
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'PlaceOrderCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.productId = '';
            this.value.userId = '';
            this.value.qty = 0;
            this.value.productName = '';
        },
        watch: {
        },
        methods: {
            placeOrder() {
                this.$emit('placeOrder', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

