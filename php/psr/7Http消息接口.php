<?php
$message = $message->withHeader('foo', 'bar');
echo $message->getHeaderLine('foo');