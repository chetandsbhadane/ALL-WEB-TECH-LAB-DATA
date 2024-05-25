class ProductService{
   constructor(){
     this.prodarr=[
        {pid:12,pname:"chair",qty:34,price:3450},
        {pid:13,pname:"table",qty:50,price:5000},
        {pid:14,pname:"shelf",qty:60,price:2000},
        {pid:15,pname:"sofa",qty:10,price:50000}]
   }
   getAllproducts(){
     return this.prodarr;
   }
   addproduct(p){
    this.prodarr.push(p)
   }
}

export default new ProductService();