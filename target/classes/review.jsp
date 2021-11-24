
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Review</title>
		<link rel="stylesheet" href="css/review.css">
	</head>
	<body>
		<div id="container">
			<h1 class="head-title">Please Review Before Paying</h1>
			<form action="execute_payment" method="post">
				<input type="hidden" name="paymentId" value="${param.paymentId}" />
				<input type="hidden" name="PayerID" value="${param.PayerID}" />

				<div class="review-item">
					<div class="title">
						<p>Transaction Details</p>
					</div>
					<ul class="review-detail">
						<li>
							<p class="message">Description:</p>
							<p class="content">${transaction.description}</p>
						</li>
						<li>
							<p class="message">Subtotal:</p>
							<p class="content">${transaction.amount.details.subtotal} USD</p>
						</li>
						<li>
							<p class="message">Shipping:</p>
							<p class="content">${transaction.amount.details.shipping} USD</p>
						</li>
						<li>
							<p class="message">Tax:</p>
							<p class="content">${transaction.amount.details.tax} USD</p>
						</li>
						<li>
							<p class="message">Total:</p>
							<p class="content">${transaction.amount.total} USD</p>
						</li>
					</ul>
				</div>
				<div class="review-item">
					<div class="title">
						<p>Payer Information</p>
					</div>
					<ul class="review-detail">
						<li>
							<p class="message">First Name:</p>
							<p class="content">${payer.firstName}</p>
						</li>
						<li>
							<p class="message">Last Name:</p>
							<p class="content">${payer.lastName}</p>
						</li>
						<li>
							<p class="message">Email:</p>
							<p class="content">${payer.email}</p>
						</li>
					</ul>
				</div>
				<div class="review-item">
					<div class="title">
						<p>Shipping Address</p>
					</div>
					<ul class="review-detail">
						<li>
							<p class="message">Recipient Name:</p>
							<p class="content">${shippingAddress.recipientName}</p>
						</li>
						<li>
							<p class="message">Line 1:</p>
							<p class="content">${shippingAddress.line1}</p>
						</li>
						<li>
							<p class="message">City:</p>
							<p class="content">${shippingAddress.city}</p>
						</li>
						<li>
							<p class="message">State:</p>
							<p class="content">${shippingAddress.state}</p>
						</li>
						<li>
							<p class="message">Country Code:</p>
							<p class="content">${shippingAddress.countryCode}</p>
						</li>
						<li>
							<p class="message">Postal Code:</p>
							<p class="content">${shippingAddress.postalCode}</p>
						</li>
					</ul>
				</div>
				<input type="submit" value="Pay Now" id="pay-btn">
			</form>
		</div>						
	</body>
</html>