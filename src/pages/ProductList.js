import React,{useState,useEffect} from 'react'
import ProductService from '../service/ProductService'
import ProductDetails from './ProductDetails'
export default function ProductList() {
    const [prodarr,setprodarr]=useState([])
    useEffect(()=>{
        var arr=ProductService.getAllproducts();
        setprodarr(arr);
    },[])
  return (
    <div>
        {prodarr.map(ob=><ProductDetails key={ob.pid} prod={ob}></ProductDetails> )}
    </div>
  )
}
