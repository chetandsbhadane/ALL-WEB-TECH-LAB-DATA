import React, { useEffect, useState } from "react";
import ProductService from '../service/ProductService'
export default function ProductTable() {
  const [prodarr,setprodarr] = useState([]);

  useEffect(()=>{
    var arr = ProductService.getAllproducts();
    setprodarr(arr);
  },[])

  return (
    <div>
      <table className="table table-striped table-dark">
        <thead>
          <tr>
            <th scope="col">Product Id</th>
            <th scope="col">Product Name</th>
            <th scope="col">Quantity</th>
            <th scope="col">Price</th>
            <th scope="col">action</th>
          </tr>
        </thead>
        <tbody>
          {
            prodarr.map((prod)=>(
              <tr>
              <th scope="row">{prod.pid}</th>
              <td>{prod.pname}</td>
              <td>{prod.qty}</td>
              <td>{prod.price}</td>
              <td>
                <button type="button" className="btn btn-success">
                  view
                </button>
                &nbsp;&nbsp;&nbsp;
                <button type="button" className="btn btn-danger">
                  Delete
                </button>
                &nbsp;&nbsp;&nbsp;
                <button type="button" className="btn btn-warning">
                  Edit
                </button>
              </td>
            </tr>
            ))
          }

        </tbody>
      </table>
    </div>
  );
}
