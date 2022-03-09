function solve() {
   document.getElementsByClassName('shopping-cart')[0].addEventListener('click', onClick);
   document.getElementsByClassName('checkout')[0].addEventListener('click', checkOut);

   const shoppingCart = [];
   const output = document.querySelector('textarea');
   output.value = '';

   function onClick(ev) {
      const elmnt = ev.target;
      if (elmnt.tagName == 'BUTTON'
         && elmnt.classList.contains('add-product')) {
         const product = elmnt.parentNode.parentNode;
         const productName = product.querySelector('.product-title').textContent;
         const productPrice = Number(product.querySelector('.product-line-price').textContent);
         
         shoppingCart.push({
            productName, 
            productPrice
         });

         output.value += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`;
      }
   }

   function checkOut() {
      const totalPrice = shoppingCart.reduce((t, c) => t + c.productPrice, 0);
      const allProducts = new Set();
      shoppingCart.forEach(product => allProducts.add(product.productName));
      output.value += `You bought ${[...allProducts.keys()].join(', ')} for ${totalPrice.toFixed(2)}.\n`;
      document.getElementsByClassName('shopping-cart')[0].removeEventListener('click', onClick);
      document.getElementsByClassName('checkout')[0].removeEventListener('click', checkOut);
   }
}